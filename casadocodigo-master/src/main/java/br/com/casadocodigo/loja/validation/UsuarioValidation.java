package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required.usuario.nome");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required.usuario.email");

		Usuario usuario = (Usuario) target;
		if(usuario.getNome() == null) {
			errors.rejectValue("nome", "field.required.usuario.nome");
		}		
	}
}
