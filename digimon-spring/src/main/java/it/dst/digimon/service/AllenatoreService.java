package it.dst.digimon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dst.digimon.model.Allenatore;
import it.dst.digimon.repository.AllenatoreRepository;

@Service
@Transactional
public class AllenatoreService {


	@Autowired
	private AllenatoreRepository allenatoreRepos;

	public void save(Allenatore allenatore) {
		allenatoreRepos.save(allenatore);
	}

	public void delete(Long id) {
		allenatoreRepos.deleteById(id);
	}

	public List<Allenatore> listAll() {
		return (List<Allenatore>) allenatoreRepos.findAll();
	}

	public Allenatore get(Long id) {
		return allenatoreRepos.findById(id).get();
	}

}
