package ch.newaccess.backendproject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AppPrivilege{
	@Id @GeneratedValue
	private Long id;
	private String privilege;
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
	
	
}
