package it.dst.digimon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dst.digimon.model.Allenatore;
import it.dst.digimon.model.Digimon;
import it.dst.digimon.repository.AllenatoreRepository;
import it.dst.digimon.repository.DigimonRepository;

@Service
@Transactional
public class DigimonService {
	
	@Autowired  DigimonRepository dig;
	@Autowired  AllenatoreRepository ale;
	
	public void save(Digimon digimon) {
		dig.save(digimon);
	}
	
	public List<Digimon> listAll() {
		return (List<Digimon>) dig.findAll();
	}
	
	public Digimon get(Long id) {
		return dig.findById(id).get();
	}
	
	public void delete(Long id) {
		dig.deleteById(id);
	}
	
	public void saveAle(Allenatore allenatore) {
		ale.save(allenatore);
	}
	
	public void deleteAle(Long id) {
		ale.deleteById(id);
	}
	
	public List<Allenatore> listAllAle() {
		return (List<Allenatore>) ale.findAll();
	}
	
	public Allenatore getAle(Long id) {
		return ale.findById(id).get();
	}
 
}
