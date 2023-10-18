package co.edu.uceva.pais_service.model.service;

import co.edu.uceva.pais_service.model.dao.IPaisDao;
import co.edu.uceva.pais_service.model.entities.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Esta clase implementa los metodos de la interfaz IPaisService y se encarga de realizar las operaciones CRUD de la entidad Pais
 */
@Service
public class PaisServiceImpl implements IPaisService{

    IPaisDao paisDao; //Se encarga de realizar las operaciones CRUD de la entidad Pais

    /**
     * Constructor de la clase PaisServiceImpl
     * @param paisDao objeto de tipo IPaisDao que se inyecta con Autowired
     */
    @Autowired
    public PaisServiceImpl(IPaisDao paisDao) {
        this.paisDao = paisDao;
    }

    /**
     * Este metodo se encarga de eliminar un pais
     * @param pais objeto de tipo Pais que se va a eliminar
     */
    @Override
    public void delete(Pais pais) {
        paisDao.delete(pais);
    }

    /**
     * Este metodo se encarga de listar todos los paises
     * @return retorna una lista de paises
     */
    @Transactional(readOnly = true) //Se encarga de manejar las transacciones de la base de datos y readOnly es para que sea de solo lectura y no se pueda modificar
    @Override
    public List<Pais> findAll() {
        return (List<Pais>) paisDao.findAll();
    }

    /**
     * Este metodo se encarga de buscar un pais por su id
     * @param id id del pais a buscar
     * @return retorna un objeto de tipo Pais
     */
    @Override
    public Pais findById(Long id) {
        return paisDao.findById(id).get();
    }

    /**
     * Este metodo se encarga de guardar un pais
     * @param pais objeto de tipo Pais que se va a guardar
     * @return retorna un objeto de tipo Pais
     */
    @Override
    public Pais save(Pais pais) {
        return paisDao.save(pais);
    }

    @Override
    public Pais update(Pais pais) {
        return paisDao.save(pais);
    }
}
