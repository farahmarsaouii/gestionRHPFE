package ch.newaccess.backendproject.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.DocumentAdministratif;
import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.repository.PrivilegeRepository;
import ch.newaccess.backendproject.repository.RoleRespository;
import ch.newaccess.backendproject.repository.UserRespository;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private PrivilegeRepository privilegeRespository;
	@Autowired
	private RoleRespository roleRespository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AppUser saveUser(AppUser user) {
		String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRespository.save(user);
	}

	public AppRole saveRole(AppRole role) {
	
		return roleRespository.save(role);
	}

	@Override
	public AppPrivilege savePrivilege(AppPrivilege privilege) {
		// TODO Auto-generated method stub
		return privilegeRespository.save(privilege);
	}

public AppUser findUserByid(Long id) {
	
return userRespository.findById(id).get();
}

	public AppUser findUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRespository.findByUserName(userName);
	}
	/*public void addRoleToUser(String userName, String roleName) {
		AppRole role = roleRespository.findByrole(roleName);
		AppUser user =userRespository.findByUserName(userName);
		user.getRoles().add(role); 
		
	}*/
	@Override
	public void affectRoleToUser(String userName, String roleName) {
		AppRole role = roleRespository.findByrole(roleName);
		AppUser user =userRespository.findByUserName(userName);
		user.setRole(role);
		//setRoles(role);
		
		
	}

	@Override
	public void addPrivilegeToRole(String privilegeName, String roleName) {
		AppRole role = roleRespository.findByrole(roleName);
		AppPrivilege privilege =privilegeRespository.findByprivilege(privilegeName);

		role.getprivileges().add(privilege);
		
	}


	@Override
	public List<AppUser> findByEquipeAndRole(Equipe equipe, AppRole role) {
		// TODO Auto-generated method stub
		return userRespository.findByEquipeAndRole(equipe,role) ;
	}

public 	List<AppRole> findRoles() {
	return roleRespository.findAll();
}

@Override
public AppUser findByPoste(Poste poste) {
	return userRespository.findByPoste(poste) ;
}

@Override
public List<AppUser> findUsers() {
	return userRespository.findAll();
}

@Override
public AppUser updateUser(AppUser user) {
	AppUser u= userRespository.findById(user.getId()).get();
	u.setUserName(user.getUserName());
	u.setCin(user.getCin());
	u.setEmail(user.getEmail());
	u.setEquipe(user.getEquipe());
	u.setIdSuperieurhierarchique(user.getIdSuperieurhierarchique());
	u.setPoste(u.getPoste());
	u.setRole(u.getRole());
	u.setImage(u.getImage());
	u.setPassword(u.getPassword());
	u.setRepassword(u.getRepassword());
	return userRespository.save(u);
}

@Override
public void deleteUser(Long idUser) {
	userRespository.deleteById(idUser);
	
}
public List<AppUser> findByRole(AppRole role){
	return userRespository.findByRole(role);
};
}
