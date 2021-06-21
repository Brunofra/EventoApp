/*package com.teste.projetonovo.EventoApp.EventoApp.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teste.projetonovo.EventoApp.EventoApp.Models.Convidado;
import com.teste.projetonovo.EventoApp.EventoApp.Models.Evento;
import com.teste.projetonovo.EventoApp.EventoApp.Repository.ConvidadoRepository;
import com.teste.projetonovo.EventoApp.EventoApp.Repository.EventoRepository;


@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	@Autowired
	private ConvidadoRepository cr;
	
	@RequestMapping(value = "/CadastrarEvento", method = RequestMethod.GET)
	public String form() {
		
		return "Evento/formEvento";
	}
	
	@RequestMapping("/deletarEvento")
	public String deletarevento(long id) {
	 Evento evento = er.findByid(id);
		er.delete(evento);
		return "redirect:/eventos";
	}
	
	@RequestMapping("/CadastrarEvento")
	public String alterarevento(long id) {
	 Evento evento = er.findByid(id);
		return "redirect:/CadastrarEvento{id}";
	}
	
	
	@RequestMapping(value = "/CadastrarEvento", method = RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes atributes) {
		if(result.hasErrors()) {
			atributes.addFlashAttribute("mensagem", "Verifique os campos");
		}
		er.save(evento);

		atributes.addFlashAttribute("mensagem", "Evento Salvo com Sucesso");
		return "redirect:/CadastrarEvento";
	
	}
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
			mv.addObject("eventos",eventos);
		return mv;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalheevento(@PathVariable("id") long id) {
		Evento evento = er.findByid(id);
		ModelAndView mv = new ModelAndView("Evento/detalhesEvento");
		mv.addObject("evento",evento);
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalheeventopost(@PathVariable("id") long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes atributes) {
		if(result.hasErrors()) {
			atributes.addFlashAttribute("mensagem", "verifique os campos");

			return "redirect:/{id}";
		}
		Evento evento = er.findByid(id);
		convidado.setEvento(evento);
		cr.save(convidado);		
		atributes.addFlashAttribute("mensagem", "Convidado salvo com sucesso");
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletarConvidado")
	public String deletarconvidado(long id) {
		Convidado convidado = cr.findByid(id);
		cr.delete(convidado);
		Evento evento = convidado.getEvento();
		long idevento = evento.getId();
		String codigo = ""+idevento;
		
		return "redirect:/"+codigo;
	}
	

}
*/