package co.edu.uceva.pais_service.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase define la entidad Pais, la cual se va a mapear con la tabla pais de la base de datos
 * Entity: Esta anotacion se encarga de mapear la clase con la tabla de la base de datos
 * Getter: Esta anotacion se encarga de generar los metodos getters de los atributos de la clase
 * Setter: Esta anotacion se encarga de generar los metodos setters de los atributos de la clase
 * AllArgsConstructor: Esta anotacion se encarga de generar un constructor con todos los atributos de la clase
 * NoArgsConstructor: Esta anotacion se encarga de generar un constructor vacio
 * Table: Esta anotacion se encarga de mapear la clase con la tabla de la base de datos
 * Id: Esta anotacion se encarga de indicar que el atributo es el id de la tabla
 */
@Entity   //Esto es parte de JPA que es Java Persistence API
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pais")
public class Pais {
    @Id
    private Long id;

    private String pais;
}
