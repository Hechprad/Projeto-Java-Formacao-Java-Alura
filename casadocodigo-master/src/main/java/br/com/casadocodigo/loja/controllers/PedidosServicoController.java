package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
public class PedidosServicoController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/pedidos")
	public Callable<ModelAndView> listarPedidos(RedirectAttributes model){
		return () ->{
			try {
				String uri = "https://book-payment.herokuapp.com/orders";
				Pedido[] response = restTemplate.getForObject(uri, Pedido[].class);
				ModelAndView modelAndView = new ModelAndView("produtos/pedidos");
				modelAndView.addObject("response", response);
				return modelAndView;
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/error");
			}
		};
	}
}
