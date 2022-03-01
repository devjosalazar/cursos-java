package co.edu.cue.webapp.banco.repositories;

import co.edu.cue.webapp.banco.entity.Cliente;
import co.edu.cue.webapp.banco.exceptions.ClienteException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CrudClienteRepository implements  CrudRepository<Cliente>{

    EntityManager em;

    public CrudClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c").getResultList();
    }

    @Override
    public Cliente obtenerPorId(int id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void guardar(Cliente cliente) {
        if(cliente != null && cliente.getIdCliente() > 0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
    }

    @Override
    public void eliminar(int id) throws ClienteException {
        Cliente cliente = obtenerPorId(id);
        if(cliente == null)
            throw new ClienteException("El cliente a eliminar no existe");
        em.remove(cliente);
    }

    @Override
    public void create(Cliente cliente) {
        em.persist(cliente);
    }
}
