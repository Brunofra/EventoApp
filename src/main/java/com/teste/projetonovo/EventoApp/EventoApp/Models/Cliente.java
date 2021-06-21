package com.teste.projetonovo.EventoApp.EventoApp.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "cliente") 
public @Data class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6559895335639755318L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private String cpf;
	
	private String dataNascimento;
	
}
