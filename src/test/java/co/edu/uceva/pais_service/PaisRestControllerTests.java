package co.edu.uceva.pais_service;

import co.edu.uceva.pais_service.model.entities.Pais;
import co.edu.uceva.pais_service.model.service.IPaisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Pruebas unitarias (unit tests) para la API RESTful que se encarga de realizar operaciones CRUD sobre una entidad
 * llamada "Pais".
 * Se importan las clases necesarias para realizar las pruebas (MockMvc, ObjectMapper, etc.), se inyecta el servicio
 * que se encarga de realizar las operaciones sobre la entidad "Pais" (IPaisService), y se definen varios métodos de
 * prueba para la API RESTful, que comprueban el correcto funcionamiento de los métodos:
 * GET, POST, PUT y DELETE de la API.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaisRestControllerTests {

    /**
     * Esta anotación @Autowired permite la inyección de dependencia, lo que significa que
     * wac (WebApplicationContext) se inicializará automáticamente con el contexto de la aplicación web.
     * El WebApplicationContext proporciona acceso a los componentes y configuraciones de Spring.
     */
    @Autowired
    private WebApplicationContext wac;

    /**
     * MockMvc es una clase que se utiliza para simular las solicitudes HTTP y probar
     * controladores y endpoints sin necesidad de un navegador web en una prueba de integración.
     */
    private MockMvc mockMvc;

    @Autowired
    private IPaisService paisService;

    /**
     * Inicializa los objetos necesarios para la prueba. En el ejemplo de código dado, este método se utiliza para
     * inicializar el objeto MockMvc, que se utiliza para simular el envío de solicitudes HTTP en la prueba de la
     * clase PaisRestController.
     */
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * Prueba del método GET "/api/pais-service/hola/{nombre}", que comprueba que se recibe el nombre correcto
     * en la respuesta.
     * @throws Exception Se lanza una excepción si no devuelve el mensaje correcto.
     */
    @Test
    public void testHolaMundo() throws Exception {
        String nombre = "Juan";
        this.mockMvc.perform(get("/api/pais-service/hola/{nombre}", nombre))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola " + nombre));
    }

    /**
     * Prueba del método GET "/api/pais-service/paises", que comprueba que se recibe una lista de países en la respuesta.
     * @throws Exception Se lanza una excepción si no devuelve la lista de países correcta.
     */
    @Test
    public void testListar() throws Exception {
        Pais pais1 = new Pais(null, "Croacia");
        Pais pais2 = new Pais(null, "España");
        paisService.save(pais1);
        paisService.save(pais2);
        this.mockMvc.perform(get("/api/pais-service/paises"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].pais", is(pais1.getPais())))
                .andExpect(jsonPath("$[0].pais", is(pais2.getPais())));
        paisService.delete(pais1);
        paisService.delete(pais2);
    }

    /**
     * Prueba del método GET "/api/pais-service/paises/{id}", que comprueba que se recibe el país correcto en la respuesta.
     * @throws Exception Se lanza una excepción si no se encuentra el país con el id especificado.
     */
    @Test
    public void testBuscarPais() throws Exception {
        Pais pais = new Pais(null, "España");
        paisService.save(pais);

        this.mockMvc.perform(get("/api/pais-service/paises/{id}", pais.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pais", is(pais.getPais())));

        paisService.delete(pais);
    }

    /**
     * Prueba del método POST "/api/pais-service/pais", que comprueba que se crea un nuevo país correctamente.
     * @throws Exception Se lanza una excepción si no se encuentra el país con el id especificado.
     */
    @Test
    public void testCrearPais() throws Exception {
        Pais pais = new Pais(null, "España");

        this.mockMvc.perform(post("/api/pais-service/pais")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pais)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.pais", is(pais.getPais())));
        paisService.delete(pais);
    }

    /**
     * Prueba del método PUT "/api/pais-service/pais", que comprueba que se actualiza un país correctamente.
     * @throws Exception Se lanza una excepción si no se encuentra el país con el id especificado.
     */
    @Test
    public void testActualizarPais() throws Exception {
        Pais pais = new Pais(null, "España");
        paisService.save(pais);
        pais.setPais("Portugal");

        this.mockMvc.perform(put("/api/pais-service/pais")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pais)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.pais", is(pais.getPais())));
        paisService.delete(pais);
    }

    /**
     * Prueba del método DELETE "/api/pais-service/paises/{id}", que comprueba que se elimina un país correctamente.
     * @throws Exception Se lanza una excepción si no se encuentra el país con el id especificado.
     */
    @Test
    public void testBorrarPais() throws Exception {
        Pais pais = new Pais(null, "Canada");
        pais = paisService.save(pais);

        this.mockMvc.perform(delete("/api/pais-service/paises/{id}", pais.getId()))
                .andExpect(status().isOk());
        assertNull(paisService.findById(pais.getId()));
    }

    /**
     * Método para convertir un objeto a una cadena JSON
     *
     * @param obj Objeto a convertir
     * @return Cadena JSON
     */
    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
