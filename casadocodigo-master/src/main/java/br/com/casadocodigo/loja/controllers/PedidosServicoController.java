package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PedidosServicoController {

	@RequestMapping(value="/pedidos", method=RequestMethod.GET)
	public String loginForm() {
		return "produtos/pedidos";
	}
}
