package org.lepro.storeprojet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRoles;
	private String roleName;

	public Role(String reoleName) {
		super();
		this.roleName = reoleName;
	}

	public Long getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(Long idRoles) {
		this.idRoles = idRoles;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String reoleName) {
		this.roleName = reoleName;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
