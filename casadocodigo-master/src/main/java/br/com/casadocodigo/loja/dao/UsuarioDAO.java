package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}

	public void gravarUsuario(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return manager.createQuery("select u from Usuario u", Usuario.class)
				.getResultList();
	}

	public boolean findUserByEmail(String email) {
		try{
				Usuario usuario = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
				if(!(usuario.getEmail().isEmpty())) {
					return true;
				}
				return false;
			} catch (NoResultException nre){
				return false;
			}
	}

	public Usuario buscaUsuario(String email) {
		Usuario usuario = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email)
				.getSingleResult();
		return usuario;
	}
	
}