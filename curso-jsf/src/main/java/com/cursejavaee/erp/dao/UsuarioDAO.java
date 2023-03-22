package com.cursejavaee.erp.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cursejavaee.erp.domain.entity.Usuario;


public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 7223004338914537389L;

	@Inject
	private EntityManager manager;

	public UsuarioDAO(){}

	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}

	public Boolean login(Usuario usuario) {
	    String jpql = "SELECT e FROM Usuario e WHERE e.user = :user AND e.password = :password";
	    TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
	    query.setParameter("user", usuario.getUser());
	    query.setParameter("password", usuario.getPassword());
	    return !query.getResultList().isEmpty();
	}
	
	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public void remover(Usuario usuario) {
		usuario = porId(usuario.getId());
		manager.remove(usuario);
	}
}
