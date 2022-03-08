package com.banco.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.banco.api.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

}
