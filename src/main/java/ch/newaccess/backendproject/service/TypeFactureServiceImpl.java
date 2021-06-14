package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.TypeFacture;
import ch.newaccess.backendproject.repository.ITypeFactureRepository;
@Service
public class TypeFactureServiceImpl implements ITypeFactureService{
	@Autowired
public ITypeFactureRepository typeFactureRepository;
	@Override
	public Optional<TypeFacture> findTypeFacture(Long idTypeFacture){
		return typeFactureRepository.findById(idTypeFacture);
	}

	@Override
	public TypeFacture addTypeFacture(TypeFacture d){
		return typeFactureRepository.save(d);
	}

	@Override
	public List<TypeFacture> listeTypeFacture(){
		return typeFactureRepository.findAll();
	}

	@Override
	public TypeFacture updateTypeFacture(TypeFacture d){
		TypeFacture type=typeFactureRepository.findById(d.getId()).get();
		type.setNomTypeFacture(d.getNomTypeFacture());
		return typeFactureRepository.save(type);
	}

	@Override
	public void deleteTypeFacture(Long idTypeFacture) {
		typeFactureRepository.deleteById(idTypeFacture);
	}

}
