package com.cursejavaee.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.cursejavaee.erp.domain.entity.Empresa;
import com.cursejavaee.erp.domain.entity.RamoAtividade;
import com.cursejavaee.erp.domain.enumeration.TipoEmpresaEnum;
import com.cursejavaee.erp.service.CadastroEmpresaService;
import com.cursejavaee.erp.service.RamoAtividadeService;
import com.cursejavaee.erp.util.FacesMessages;

@Named
@ManagedBean(name = "gestaoEmpresasMB")
@ViewScoped
public class GestaoEmpresasMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;
	
	@Inject
	private RamoAtividadeService ramoAtividadeService;
	
	private Empresa empresa;
	private List<Empresa> listaEmpresas;
	
	private String termoPesquisa;
	
	private Converter ramoAtividadeConverter;
	
	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void prepararEdicao() {
		ramoAtividadeConverter = new RamoAtividadeConverter(Arrays.asList(empresa.getRamoAtividade())) ;
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		
		atualizarResgistros();
		
		messages.info("Empresa salva com sucesso.");
		
		PrimeFaces.current().ajax().update(Arrays.asList("frm:empresasDataTable", "frm:messages"));
	}
	
	public void excluir() {
		cadastroEmpresaService.excluir(empresa);
		empresa = null;
		atualizarResgistros();
		
		messages.info("Empresa excluída com sucesso.");
	}
	
	public void pesquisar() {
		listaEmpresas = cadastroEmpresaService.pesquisar(termoPesquisa);
		
		if (listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}	
	}
	
	public void todasEmpresas() {
		listaEmpresas = cadastroEmpresaService.todasEmpresas();
	}
	
	public void atualizarResgistros() {
		if(jaHouvePesquisa()) {
			pesquisar();
		}else {
			todasEmpresas();
		}
	}
	
	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
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
	
	public TipoEmpresaEnum[] getTiposEmpresa() {
		return TipoEmpresaEnum.values();
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		List<RamoAtividade> listaRamoAtividades = ramoAtividadeService.completarRamoAtividade(termo);
		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
		return listaRamoAtividades;
	}
	
	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public boolean isEmpresaSeleciona() {
		return empresa != null && empresa.getId() != null;
	}
	
}
