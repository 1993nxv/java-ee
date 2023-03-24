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

}
