package com.banco.api.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.banco.exceptions.ClienteException;
import com.banco.api.entities.Cliente;
import com.banco.api.repositories.IClienteRepository;


@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	public ClienteServiceImpl() {
		
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente findById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void update(Cliente cliente, int id) throws ClienteException {
		if(findById(id) == null)
			throw new ClienteException("El cliente no existe");
		
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
}
