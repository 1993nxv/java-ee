package com.cursejavaee.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.cursejavaee.erp.dao.RamoAtividadeDAO;
import com.cursejavaee.erp.domain.entity.RamoAtividade;

public class RamoAtividadeService implements Serializable {
	private static final long serialVersionUID = -3465519471202680116L;
	
	@Inject
	private RamoAtividadeDAO ramoAtividadeDAO;
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		return ramoAtividadeDAO.pesquisar(termo);
	}

}
