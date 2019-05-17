package br.com.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
public class UsuarioController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@RequestMapping("/usuarios/form")
    public String formUsuario(Usuario usuario){
        return "usuarios/formUsuarios";
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public String gravarUsuario(@Valid Usuario usuario){
	    System.out.println(usuario);

	    return "usuarios/listaUsuarios";
	}

}
