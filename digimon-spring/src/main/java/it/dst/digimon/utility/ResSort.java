package it.dst.digimon.utility;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.dst.digimon.model.Digimon;

public class ResSort implements Strategy {

	@Override
	public void sort(List<Digimon> lista) {
		Collections.sort(lista, new Comparator<Digimon>() {

			@Override
			public int compare(Digimon p1, Digimon p2) {
				if (p1.getRes() > p2.getRes()) {
					return 1;
				} else if (p1.getRes() < p2.getRes()) {
					return -1;
				}

				return 0;
			}

		});

	}

}
