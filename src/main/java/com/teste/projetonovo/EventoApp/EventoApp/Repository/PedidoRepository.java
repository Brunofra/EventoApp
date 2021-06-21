package com.teste.projetonovo.EventoApp.EventoApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.teste.projetonovo.EventoApp.EventoApp.Models.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String>{

	//Iterable<Pedido> finByPedido(Pedido pedido);
	
	Pedido findByid(long id);
}
