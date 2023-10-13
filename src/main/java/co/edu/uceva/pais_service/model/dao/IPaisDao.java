package co.edu.uceva.pais_service.model.dao;

import co.edu.uceva.pais_service.model.entities.Pais;
import org.springframework.data.repository.CrudRepository;

/**
 * Esta interfaz hereda de CrudRepository y se encarga de realizar las operaciones CRUD de la entidad Pais
 */
public interface IPaisDao extends CrudRepository<Pais, Long> { // Pais es la entidad y Long es el tipo de dato del id de la entidad
}
