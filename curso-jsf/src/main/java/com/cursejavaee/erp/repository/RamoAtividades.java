package com.cursejavaee.erp.repository;

import com.cursejavaee.erp.model.RamoAtividade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class RamoAtividades implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public RamoAtividades(){}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<RamoAtividade> pesquisar(String descricao) {
		String jpql = "from RamoAtividade where descricao like :descricao";

		TypedQuery<RamoAtividade> query = manager.createQuery(jpql, RamoAtividade.class);

		query.setParameter("descricao", descricao + "%");

		return query.getResultList();
	}
	
}
