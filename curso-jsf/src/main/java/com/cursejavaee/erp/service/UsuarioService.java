package com.cursejavaee.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.cursejavaee.erp.dao.UsuarioDAO;
import com.cursejavaee.erp.domain.entity.Usuario;
import com.cursejavaee.erp.util.Transacional;


public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 4830713835782823773L;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	

	public Boolean login(Usuario usuario) {
		return usuarioDAO.login(usuario);
	}
	
	@Transacional
	public void guardar(Usuario usuario) {
		usuarioDAO.guardar(usuario);
	}
	
	@Transacional
	public void remover(Usuario usuario) {
		usuarioDAO.remover(usuario);
	}
	
}
