package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@RequestMapping("/form")
    public ModelAndView formUsuario(Usuario usuario){
        return new ModelAndView("usuarios/formUsuarios");
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravarUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes){
		
		if (result.hasErrors()) {
			return formUsuario(usuario);
		}
		
		if(usuarioDao.findUserByEmail(usuario.getEmail())){
			redirectAttributes.addFlashAttribute("falha", "Usuário '"+ usuario.getEmail() + "' já existe");
			return new ModelAndView("redirect:/usuarios");
		}
		
		//Encriptando a senha
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuario.setSenhaRepetida(passwordEncoder.encode(usuario.getSenhaRepetida()));
		
		usuarioDao.gravarUsuario(usuario);
		
		redirectAttributes.addFlashAttribute("sucesso", "Usuário '" + usuario.getNome() + "' cadastrado com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView listarUsuarios(Usuario usuario){
        List<Usuario> usuarios = usuarioDao.listarUsuarios();
		ModelAndView modelAndView = new ModelAndView("usuarios/listaUsuarios");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
    }
	

}
