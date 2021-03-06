package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AppPrivilege{
	@Id @GeneratedValue
	private Long id;
	private String privilege;
	@ManyToMany
	@JsonIgnore
	private Collection<AppRole> roles =new ArrayList<AppRole>();
	public AppPrivilege() {
		super();
	
	}
	
	public AppPrivilege(Long id, String privilege) {
		super();
		this.id = id;
		this.privilege = privilege;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	
	
}
