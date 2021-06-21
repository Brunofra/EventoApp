package com.teste.projetonovo.EventoApp.EventoApp.Repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.teste.projetonovo.EventoApp.EventoApp.Models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	
	//Iterable<Cliente> findbyClient(Cliente cliente);
	Cliente findByid(long id);
}
