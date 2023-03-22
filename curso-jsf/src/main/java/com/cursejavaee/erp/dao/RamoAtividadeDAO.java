package com.cursejavaee.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cursejavaee.erp.domain.entity.RamoAtividade;

public class RamoAtividadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public RamoAtividadeDAO() {
	}

	public RamoAtividadeDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<RamoAtividade> pesquisar(String descricao) {

		String jpql = "SELECT e FROM RamoAtividade e WHERE lower(unaccent(e.descricao)) "
				+ "like lower(unaccent(:descricao))";
		TypedQuery<RamoAtividade> query = manager.createQuery(jpql, RamoAtividade.class);
		query.setParameter("descricao", "%" + descricao.replaceAll("[^a-zA-Z0-9\\s]", "") + "%");
		return query.getResultList();
	}

}
