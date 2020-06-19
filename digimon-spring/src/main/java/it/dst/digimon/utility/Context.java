package it.dst.digimon.utility;

import java.util.List;

import it.dst.digimon.model.Digimon;

public class Context {

	private final Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void ordinamento(List<Digimon> lista) {
		strategy.sort(lista);
	}

}