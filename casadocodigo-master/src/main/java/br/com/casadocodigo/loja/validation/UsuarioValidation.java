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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required.usuario.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senhaRepetida", "field.required");

		Usuario usuario = (Usuario) target;
		
		if(usuario.getSenha().length() < 5) {
			errors.rejectValue("senha", "field.required.usuario.senha_curta");
		}
		
		if(!(usuario.getSenha().equals(usuario.getSenhaRepetida()))) {
			errors.rejectValue("senhaRepetida", "field.required.usuario.senha_repetida");
		}
	}
}
