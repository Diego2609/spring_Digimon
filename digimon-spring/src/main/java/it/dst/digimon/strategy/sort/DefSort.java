package it.dst.digimon.strategy.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.dst.digimon.model.Digimon;

public class DefSort implements Strategy<Digimon> {

	@Override
	public void sort(List<Digimon> lista) {
		Collections.sort(lista, new Comparator<Digimon>() {

			@Override
			public int compare(Digimon p1, Digimon p2) {
				if (p1.getDef() < p2.getDef()) {
					return 1;
				} else if (p1.getDef() > p2.getDef()) {
					return -1;
				}

				return 0;
			}

		});

	}

}