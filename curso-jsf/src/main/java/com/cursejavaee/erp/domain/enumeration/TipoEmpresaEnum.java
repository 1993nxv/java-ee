package com.cursejavaee.erp.domain.enumeration;

public enum TipoEmpresaEnum {
	
	MEI("Microempreendedor Individual"),
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String descricao;
	
	TipoEmpresaEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
}
