package com.cursejavaee.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.cursejavaee.erp.util.FacesMessages;

@ManagedBean(name = "usuarioMB")
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = -2143711206050606398L;
	
	@Inject
	private FacesMessages messages;
	
	
}
