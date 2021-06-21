package com.teste.projetonovo.EventoApp.EventoApp.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teste.projetonovo.EventoApp.EventoApp.Models.Produto;
import com.teste.projetonovo.EventoApp.EventoApp.Repository.ProdutoRepository;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoRepository er;
	
	
	@RequestMapping(value = "/p/CadastrarProduto", method = RequestMethod.GET)
	public String form() {

		return "Produtos/formProduto";
	}
	
	@RequestMapping(value = "/CadastrarProduto" , method = RequestMethod.POST)
	public String form(@Valid Produto produto, BindingResult result, RedirectAttributes atributes) {
		if(result.hasErrors()) {
			atributes.addFlashAttribute("mensagem", "verifique os campos");
		}
		er.save(produto);
		
		atributes.addFlashAttribute("mensagem", "cliente salvo com sucesso");
		
		return "redirect:/produtos";
	}
	
	@RequestMapping("DeletarProduto")
	public String deletarProduto(long id) {
		Produto produto = er.findByid(id);
		er.delete(produto);
		return "redirect:/produtos";
	}
	
	@RequestMapping(value = "/{ids}", method = RequestMethod.GET)
	public ModelAndView detalhesProdutos(@PathVariable("ids") long id) {
		Produto produto = er.findByid(id); 
		ModelAndView mv = new ModelAndView("Produtos/detalhesProduto");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@RequestMapping("/p/lista")
	public ModelAndView listarprodutos() {
		
		ModelAndView mv = new ModelAndView("Produtos/ListaProdutos");
		Iterable<Produto> produtos = er.findAll();
		mv.addObject("produtos", produtos);
		 
		return mv;
	}
}
