package com.cursejavaee.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cursejavaee.erp.model.Empresa;
import com.cursejavaee.erp.model.RamoAtividade;
import com.cursejavaee.erp.model.TipoEmpresa;
import com.cursejavaee.erp.repository.Empresas;
import com.cursejavaee.erp.repository.RamoAtividades;
import com.cursejavaee.erp.util.FacesMessages;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Inject
	private FacesMessages messages;
	
	private List<Empresa> listaEmpresas;
	
	private String termoPesquisa;
	
	@Inject
	private RamoAtividades ramoAtividades;
	
	private Converter ramoAtividadeConverter;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if (listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
		
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
		return listaRamoAtividades;
	}
	
	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}

}
