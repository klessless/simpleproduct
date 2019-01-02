package com.first.shopify.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String nomRole;
	
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}
}
