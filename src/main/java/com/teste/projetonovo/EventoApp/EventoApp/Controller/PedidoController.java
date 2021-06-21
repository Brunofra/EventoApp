package com.teste.projetonovo.EventoApp.EventoApp.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teste.projetonovo.EventoApp.EventoApp.Models.Cliente;
import com.teste.projetonovo.EventoApp.EventoApp.Models.Pedido;
import com.teste.projetonovo.EventoApp.EventoApp.Repository.PedidoRepository;

@Controller
public class PedidoController {

	@Autowired
	private PedidoRepository er;
	
	@RequestMapping(value = "/CadastrarPedido", method = RequestMethod.GET)
	public String form() {
		return "Pedidos/formPedido";
	}
	
	@RequestMapping(value = "/CadastrarPedido" , method = RequestMethod.POST)
	public String form(@Valid Pedido pedido, BindingResult result, RedirectAttributes atributes) {
		if(result.hasErrors()) { 
			atributes.addFlashAttribute("mensagem", "verifique os campos");
		}
		
		er.save(pedido);
		
		atributes.addFlashAttribute("mensagem", "cliente salvo com sucesso");
		
		return "redirect:/CadastrarPedido";
	}
	
	
	@RequestMapping("/pedidos")
	public ModelAndView listarclientes() {
		
		ModelAndView mv = new ModelAndView("ListaPedidos");
		Iterable<Pedido> pedidos = er.findAll();
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
}
