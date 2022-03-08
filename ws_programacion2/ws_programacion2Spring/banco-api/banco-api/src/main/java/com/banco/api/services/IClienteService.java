package com.banco.api.services;

import java.util.List;

import com.api.banco.exceptions.ClienteException;
import com.banco.api.entities.Cliente;

public interface IClienteService {
	
	
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findById(int id);
	public void update(Cliente cliente, int id) throws ClienteException;
	public void delete(Cliente cliente);

}
