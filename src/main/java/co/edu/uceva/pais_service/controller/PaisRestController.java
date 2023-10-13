package co.edu.uceva.pais_service.controller;

import co.edu.uceva.pais_service.model.service.IPaisService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Esta clase se encarga de exponer los servicios rest de la entidad pais y se mapea con la url /api/pais-service
 */
@RestController
@RequestMapping("/api/pais-service")
public class PaisRestController {

   private IPaisService paisService; //Servicio de la entidad pais para realizar las operaciones CRUD

    /**
     * Constructor de la clase PaisRestController
     * @param paisService servicio de la entidad pais para realizar las operaciones CRUD que se inyecta con Autowired
     */
   @Autowired
   public PaisRestController(IPaisService paisService){
       this.paisService = paisService;
   }


    /**
     * Este metodo se encarga de retornar un saludo con el nombre que se le pase por parametro en la url
     * @param nombre nombre de la persona a saludar
     * @return retorna un string con el saludo
     */
   @GetMapping("/hola/{nombre}")
   public String holaMundo(@PathVariable("nombre") String nombre){
            return "Hola "+ nombre;
    }


}
