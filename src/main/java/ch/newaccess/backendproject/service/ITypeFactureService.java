package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.TypeFacture;

public interface ITypeFactureService {
	public Optional<TypeFacture> findTypeFacture(Long idTypeFacture);
	public TypeFacture addTypeFacture(TypeFacture d);
	public List<TypeFacture> listeTypeFacture();
	public TypeFacture updateTypeFacture(TypeFacture d);
	public void deleteTypeFacture(Long idTypeFacture);
}
