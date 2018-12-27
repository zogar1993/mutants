package net.jemzart.mutants;

import net.jemzart.mutants.dna.DNA;
import net.jemzart.mutants.traversers.*;

import java.util.ArrayList;
import java.util.List;

public class MutantIdentifier {
	private DNA dna;
	private List<LineTraverser> traversers = new ArrayList<>();
	private byte found = 0;
	private MutantIdentifier(String[] raw){
		dna = new DNA(raw);
		traversers.add(new HorizontalTraverser(dna));
		traversers.add(new VerticalTraverser(dna));
		traversers.add(new DiagonalTraverser(dna));
		traversers.add(new InvertedDiagonalTraverser(dna));
	}

	public static boolean isMutant(String[] dna) {
		MutantIdentifier mutantIdentifier = new MutantIdentifier(dna);
		return mutantIdentifier.isMutant();
	}

	private boolean isMutant(){
		if (dna.length() < 4) return false;

		for (LineTraverser traverser : traversers)
			if(scanWithTraverser(traverser))
				return true;//The search is over, mutant pattern found.

		return false;
	}

	private boolean scanWithTraverser(LineTraverser traverser) {
		do {
			if(scanLine(traverser))
				return true;//The search is over, mutant pattern found.
		} while (traverser.nextLine());
		return false;
	}

	private boolean scanLine(LineTraverser traverser) {
		if (!traverser.advance(1)) return false;
		char last = traverser.current();

		//Since I must find 4 in a row, advancing 2 at a time makes sure I do not miss a match.
		//The amount of operations is roughly halved in an optimistic use case.
		while (traverser.advance(2)) {
			char current = traverser.current();
			if (current == last) {
				if (current == traverser.retrieve(-1)) {//check between current and last one
					if (current == traverser.retrieve(-3)) {//check before the just found three in a row
						found++;
						if (theSearchIsOver()) return true;//mutant pattern found.
						skip(current, traverser);
					} else {
						if (traverser.advance(1)) {//not end of line
							if (current == traverser.current()) {//check after the just found three in a row
								found++;
								if (theSearchIsOver()) return true;//mutant pattern found.
								skip(current, traverser);
							}
						}
					}
				}
			}
			last = current;
		}
		return false;
	}

	private boolean theSearchIsOver(){
		return found > 1;
	}

	private void skip(char value, LineTraverser traverser){
		while (traverser.advance(1))
			if (traverser.current() != value){
				traverser.advance(-1);//set it at last occurrence of value
				return;
			}
	}
}
