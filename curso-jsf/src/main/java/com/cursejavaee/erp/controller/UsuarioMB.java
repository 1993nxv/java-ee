package com.cursejavaee.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cursejavaee.erp.domain.entity.Usuario;
import com.cursejavaee.erp.service.UsuarioService;
import com.cursejavaee.erp.util.FacesMessages;

@Named
@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = -2143711206050606398L;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	private Boolean logado;
	
	public void preparaUsuario() {
		usuario = new Usuario();
	}
	
	public void fazerLogin() {
		if (usuarioService.login(usuario)) {
			setLogado(true);
			messages.info("Logado com sucesso: " + usuario.getUser() );
			
		}else {
			setLogado(false);
			messages.info("Usuario ou Senha incorretos!");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}
	
}
