package com.teste.projetonovo.EventoApp.EventoApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
