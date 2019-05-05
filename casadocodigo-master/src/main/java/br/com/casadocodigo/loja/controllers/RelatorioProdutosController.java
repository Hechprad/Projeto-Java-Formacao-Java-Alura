package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping(value="/relatorio-produtos", method=RequestMethod.GET)
	@ResponseBody
	public Produto mostraProdutosCadastrados() {
		Produto produto = (Produto) dao.selecionaProdutosPorData();
		return produto;
	}

}
