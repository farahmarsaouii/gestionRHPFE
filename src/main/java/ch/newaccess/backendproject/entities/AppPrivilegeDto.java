package ch.newaccess.backendproject.entities;
import java.util.ArrayList;
import java.util.Collection;



public class AppPrivilegeDto{

	private Long id;
	private String privilege;

	private Collection<AppRole> roles =new ArrayList<AppRole>();
	public AppPrivilegeDto() {
		super();
	
	}
	
	public AppPrivilegeDto(Long id, String privilege) {
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
