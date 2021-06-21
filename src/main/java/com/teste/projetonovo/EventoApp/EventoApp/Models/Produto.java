package com.teste.projetonovo.EventoApp.EventoApp.Models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity(name = "produto")
public @Data class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -467065767574697674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;
	
	private BigDecimal quantidade;
	

}
