package com.cursejavaee.erp.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.cursejavaee.erp.util.HashUtils;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -7842537415291108901L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "user", nullable = false, length = 80)
	String user;
	
	@NotEmpty
	@Column(name = "password", nullable = false, length = 32)
	String password;
	
	public Long getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = HashUtils.getHashMd5(password);
	}
	
	@Override
	public String toString() {
		return this.user + this.password;
	}

}