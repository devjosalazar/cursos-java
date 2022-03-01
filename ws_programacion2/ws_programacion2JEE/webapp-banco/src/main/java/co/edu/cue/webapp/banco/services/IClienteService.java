package co.edu.cue.webapp.banco.services;

import co.edu.cue.webapp.banco.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listar();
    Cliente obtenerPorId(int id);
    void guardar(Cliente cliente);
    void eliminar(int id);

    void createCliente(Cliente cliente);
}
