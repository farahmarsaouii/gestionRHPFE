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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AppRole{
	@Id @GeneratedValue
	private Long id;
	private String role;
	@ManyToMany(fetch = FetchType.EAGER) 
	private Collection<AppPrivilege> privileges =new ArrayList<AppPrivilege>();
	
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private Collection<AppUser> users =new ArrayList<AppUser>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Collection<AppPrivilege> getprivileges() {
		return privileges;
	}
	public void setprivileges(Collection<AppPrivilege> privileges) {
		this.privileges = privileges;
	}
	public AppRole(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public AppRole() {
		super();
	}
	@JsonIgnore
	@JsonProperty("privileges") 
	public Collection<AppPrivilege> getPrivileges() {
		return privileges;
	}
	@JsonIgnore
	public void setPrivileges(Collection<AppPrivilege> privileges) {
		this.privileges = privileges;
	}
	public Collection<AppUser> getUsers() {
		return users;
	}
	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}
	
	
	
}
