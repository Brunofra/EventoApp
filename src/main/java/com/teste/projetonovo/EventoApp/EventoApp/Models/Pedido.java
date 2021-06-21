package com.teste.projetonovo.EventoApp.EventoApp.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name = "pedido")
public @Data class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2729618998574000273L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Cliente cliente;
	
	private BigDecimal quantidadeCompra;
	
	private Timestamp dataCompra;
	@OneToMany
	private List<Produto> produtos;
	
}
