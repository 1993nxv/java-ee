package com.cursejavaee.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cursejavaee.erp.dao.EmpresaDAO;
import com.cursejavaee.erp.domain.entity.Empresa;
import com.cursejavaee.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaDAO empresaDAO;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresaDAO.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresaDAO.remover(empresa);
	}
	
	public List<Empresa> pesquisar(String termoPesquisa){
		return empresaDAO.pesquisar(termoPesquisa);
	}
	
	public List<Empresa> todasEmpresas(){
		return empresaDAO.todas();
	}

}
