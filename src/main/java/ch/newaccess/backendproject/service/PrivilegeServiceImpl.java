package ch.newaccess.backendproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppPrivilegeDto;
import ch.newaccess.backendproject.entities.AppPrivilege;

import ch.newaccess.backendproject.repository.PrivilegeRepository;


@Service
public class PrivilegeServiceImpl implements IPrivilegeService{
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Override
	public AppPrivilege findPrivilegeById(Long idPrivilege) {
		// TODO Auto-generated method stub
		return privilegeRepository.findById(idPrivilege).get();
	}

	@Override
	public AppPrivilege addPrivilege(AppPrivilege privilege) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<AppPrivilegeDto> listePrivilege() {
		List<AppPrivilegeDto> privilegesDto = new ArrayList<AppPrivilegeDto>();
		List<AppPrivilege> privileges = new ArrayList<AppPrivilege>();
		privileges=privilegeRepository.findAll();
		for(AppPrivilege r:privileges) {
			AppPrivilegeDto privilegedto=new AppPrivilegeDto();
			privilegedto.setId(r.getId());
			privilegedto.setPrivilege(r.getPrivilege());
			//privilegedto.setRoles(r.getRoles());
			
			
			privilegesDto.add(privilegedto);
		}
		return privilegesDto;
	}*/

	@Override
	public AppPrivilege updatePrivilege(AppPrivilege privilege) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePrivilege(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AppPrivilege> listePrivilege() {
		// TODO Auto-generated method stub
		return privilegeRepository.findAll();
	}

	@Override
	public AppPrivilege findPrivilegeByName(String privilegeName) {
		// TODO Auto-generated method stub
		return privilegeRepository.findByprivilege(privilegeName);
	}

}
