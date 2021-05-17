package ch.newaccess.backendproject.entities;
import java.util.ArrayList;
import java.util.Collection;

public class AppRoleDto{

	private Long id;
	private String role;
    private Collection<AppPrivilegeDto> privileges =new ArrayList<AppPrivilegeDto>();
	private Collection<AppUser> users =new ArrayList<AppUser>();

	
	
	public AppRoleDto(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public AppRoleDto() {
		super();
	}
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
	public Collection<AppPrivilegeDto> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Collection<AppPrivilegeDto> privileges) {
		this.privileges = privileges;
	}
	public Collection<AppUser> getUsers() {
		return users;
	}
	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}
	
	
	
	
}
