package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@RequestMapping("/form")
    public ModelAndView formUsuario(Usuario usuario){
        return new ModelAndView("usuarios/formUsuarios");
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravarUsuario(@Valid Usuario usuario, RedirectAttributes redirectAttributes, BindingResult result){
		
		if (result.hasErrors()) {
			return formUsuario(usuario);
		}
		
		dao.gravarUsuario(usuario);
		
		redirectAttributes.addFlashAttribute("message", "Usuário " + usuario.getNome() + ", cadastrado com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView listarUsuarios(Usuario usuario){
        List<Usuario> usuarios = dao.listarUsuarios();
		ModelAndView modelAndView = new ModelAndView("usuarios/listaUsuarios");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
    }
	

}
