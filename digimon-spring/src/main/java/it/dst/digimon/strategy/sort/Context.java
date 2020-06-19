package it.dst.digimon.strategy.sort;

import java.util.List;

public class Context<T> {

	private Strategy<T> strategy;

	public Context(Strategy<T> strategy) {
		this.strategy = strategy;
	}

	public void ordinamento(List<T> lista) {
		strategy.sort(lista);
	}
	
	public void changeStrategy(Strategy<T> strategy) {
		this.strategy = strategy;
	}
	
	
}