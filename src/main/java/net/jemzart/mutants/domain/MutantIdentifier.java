package net.jemzart.mutants.domain;

import net.jemzart.mutants.domain.dna.DNA;
import net.jemzart.mutants.domain.matching.MatchFinder;
import net.jemzart.mutants.domain.traversers.*;

import java.util.ArrayList;
import java.util.List;

public class MutantIdentifier {
	private DNA dna;
	private List<LineTraverser> traversers = new ArrayList<>();
	private MatchFinder matchFinder = new MatchFinder();

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
			if(matchFinder.scan(traverser))
				return true;//The search is over, mutant pattern found.

		return false;
	}
}
