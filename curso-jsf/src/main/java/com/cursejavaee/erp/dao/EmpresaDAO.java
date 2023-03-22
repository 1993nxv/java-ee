package com.cursejavaee.erp.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cursejavaee.erp.domain.entity.Empresa;


public class EmpresaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public EmpresaDAO(){}

	public EmpresaDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
	    String jpql = "SELECT e FROM Empresa e WHERE lower(unaccent(e.razaoSocial)) "
	    			  + "like lower(unaccent(:razaoSocial))";
	    TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
	    query.setParameter("razaoSocial", "%" + nome.replaceAll("[^a-zA-Z0-9\\s]", "") + "%");
	    return query.getResultList();
	}
	
	public List<Empresa> todas(){
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	
	
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}

}
