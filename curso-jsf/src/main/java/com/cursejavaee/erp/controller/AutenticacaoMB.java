package com.cursejavaee.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cursejavaee.erp.domain.entity.Usuario;
import com.cursejavaee.erp.service.UsuarioService;
import com.cursejavaee.erp.util.FacesMessages;

@Named
@ManagedBean(name = "autenticacaoMB")
@SessionScoped
public class AutenticacaoMB implements Serializable {

	private static final long serialVersionUID = 315776467292959196L;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	private Usuario usuarioLogado;
	
	public void preparaUsuario() {
		usuario = new Usuario();
	}
	
	private Boolean logado = false;
	
	public String fazerLogin() {
		if (usuarioService.login(usuario)) {
			messages.info("Logado com sucesso: " + usuario.getUser() );
			setUsuarioLogado(usuario);
			setLogado(true);
			return "/pages/cadastros/empresas/GestaoEmpresas.xhtml?faces-redirect=true";
		}else {
			messages.info("Usuario ou Senha incorretos!");
			setLogado(false);
			return "";
		}
	}
	
    public Usuario getUsuario() {
		return usuario;
	}
    
    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = new Usuario();
		this.usuarioLogado = usuario;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/login/Login.xhtml?faces-redirect=true";
	}
	
}
