package co.edu.uceva.pais_service.controller;

import co.edu.uceva.pais_service.model.entities.Pais;
import co.edu.uceva.pais_service.model.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Esta clase se encarga de exponer los servicios rest de la entidad pais y se mapea con la url /api/pais-service
 */
@RestController
@RequestMapping("/api/pais-service")
public class PaisRestController {

    private IPaisService paisService; //Servicio de la entidad pais para realizar las operaciones CRUD

    /**
     * Constructor de la clase PaisRestController
     *
     * @param paisService servicio de la entidad pais para realizar las operaciones CRUD que se inyecta con Autowired
     */
    @Autowired
    public PaisRestController(IPaisService paisService) {
        this.paisService = paisService;
    }


    /**
     * Este metodo se encarga de retornar un saludo con el nombre que se le pase por parametro en la url
     *
     * @param nombre nombre de la persona a saludar
     * @return retorna un string con el saludo
     */
    @GetMapping("/hola/{nombre}")
    public String holaMundo(@PathVariable("nombre") String nombre) {
        return "Hola " + nombre;
    }

    /**
     * Metodo que lista los paises
     *
     * @return Lista de paises
     */
    @GetMapping("/paises")
    public List<Pais> listar() {
        return paisService.findAll();
    }

    /**
     * Metodo que busca un pais por su id
     *
     * @param id id del pais a buscar
     * @return Pais encontrado
     */
    @GetMapping("/paises/{id}")
    public Pais buscarPais(@PathVariable("id") Long id) {
        return paisService.findById(id);
    }


}
