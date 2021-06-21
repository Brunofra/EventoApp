package com.teste.projetonovo.EventoApp.EventoApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.teste.projetonovo.EventoApp.EventoApp.Models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{

	//Iterable<Produto> findByProduto(Produto produto);
	
	Produto findByid(long id);
}
