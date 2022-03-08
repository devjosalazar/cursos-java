package com.banco.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.api.entities.Cliente;
import com.banco.api.services.ClienteServiceImpl;

//@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
@RequestMapping("/api/banco")
public class ClienteRestController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	
	@GetMapping("/clientes")
	public List<Cliente> getClients() {
		return clienteServiceImpl.findAll();
	}


	
//	@GetMapping("/clientes/{id}")
//	public ArrayList<Cliente> getClient(@PathVariable int id) {
//		return null;
//	}
//
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public void createClient(@RequestBody Cliente cliente) {
		
		System.out.println("Servicio de crear solicitado");
		
		clienteServiceImpl.save(cliente);
	}
//	
//	@PutMapping("cliente/{id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public Cliente updateClient(@RequestBody Cliente cliente, @PathVariable int id) {
//		return cliente;
//	}
//	
//	@DeleteMapping("cliente/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteClient(@PathVariable int id) {
//		
//	}
	
	
//	private ArrayList<Cliente> getClientes() {
//		ArrayList<Cliente> listaClientes = new ArrayList<>();
//		
//		Cliente cliente = new Cliente();
//		cliente.setNombre("juan");
//		listaClientes.add(cliente);
//		return listaClientes;
//	}
	
}


