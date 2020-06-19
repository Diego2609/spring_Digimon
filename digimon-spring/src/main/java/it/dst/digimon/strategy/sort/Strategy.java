package it.dst.digimon.strategy.sort;

import java.util.List;

import it.dst.digimon.model.Digimon;

public interface Strategy<T> {
	public void sort(List<T> lista);
}
