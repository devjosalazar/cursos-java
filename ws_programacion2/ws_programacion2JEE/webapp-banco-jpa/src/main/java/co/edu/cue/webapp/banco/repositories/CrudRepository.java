package co.edu.cue.webapp.banco.repositories;

import co.edu.cue.webapp.banco.exceptions.ClienteException;

import java.util.List;

public interface CrudRepository <T>{

    List<T> listar();
    T obtenerPorId(int id);
    void guardar(T t);
    void eliminar(int id) throws ClienteException;
}
