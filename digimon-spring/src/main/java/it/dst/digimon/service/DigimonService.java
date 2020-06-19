package it.dst.digimon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dst.digimon.model.Digimon;
import it.dst.digimon.repository.DigimonRepository;

@Service
@Transactional
public class DigimonService {
	
	@Autowired  
	private DigimonRepository digimonRepos;
	
	public void save(Digimon digimon) {
		digimonRepos.save(digimon);
	}
	
	public List<Digimon> listAll() {
		return (List<Digimon>) digimonRepos.findAll();
	}
	
	public Digimon get(Long id) {
		return digimonRepos.findById(id).get();
	}
	
	public void delete(Long id) {
		digimonRepos.deleteById(id);
	}
	
 
}
