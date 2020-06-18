package it.dst.digimon.repository;

import org.springframework.data.repository.CrudRepository;

import it.dst.digimon.model.Digimon;


public interface DigimonRepository extends CrudRepository<Digimon, Long> {

}
