package com.teste.projetonovo.EventoApp.EventoApp.Controller;

import java.math.BigDecimal;

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

import com.teste.projetonovo.EventoApp.EventoApp.Models.Cliente;
import com.teste.projetonovo.EventoApp.EventoApp.Repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository er;
	
	@RequestMapping(value = "/c/CadatrarCliente", method = RequestMethod.GET)
	public String form() {
		return "Clientes/formCliente";
	}
	
	
	@RequestMapping("/c/deletarCliente")
	public String deletarCliente(long id) {
		Cliente cliente = er.findByid(id);
		er.delete(cliente);
		return "redirect:/c/lista";
	}
	
	@RequestMapping(value="/c/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesCliente(@PathVariable("id") long id){
		Cliente cliente = er.findByid(id);
		ModelAndView mv = new ModelAndView("Clientes/detalhesCliente");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	@RequestMapping(value="/c/atualizar", method=RequestMethod.POST)
	public ModelAndView alterarCliente(@PathVariable("id") long id){
		Cliente cliente = er.findByid(id);
		ModelAndView mv = new ModelAndView("Clientes/formCliente");
		mv.addObject("cliente", cliente);

		return mv;
	}
	@RequestMapping("/c/lista")
	public ModelAndView listarclientes() {
		
		ModelAndView mv = new ModelAndView("ListaClientes");
		Iterable<Cliente> clientes = er.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}

	@RequestMapping(value = "/c/CadastrarCliente" , method = RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes atributes) {
		if(result.hasErrors()) {
			atributes.addFlashAttribute("mensagem", "verifique os campos");
		}
		er.save(cliente);
		
		atributes.addFlashAttribute("mensagem", "cliente salvo com sucesso");
		return "redirect:/c/lista";
	}
}
