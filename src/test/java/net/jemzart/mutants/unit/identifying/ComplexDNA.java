package net.jemzart.mutants.unit.identifying;

import net.jemzart.mutants.domain.MutantIdentifier;
import org.junit.Test;

public class ComplexDNA {
	@Test
	public void fiveInARowSequenceIsNotEnough(){
		String[] dna = {
			"CCCCC",
			"AAGTT",
			"AAGTT",
			"TTCAA",
			"TTCAA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}

	@Test
	public void sixInARowSequenceIsNotEnough(){
		String[] dna = {
			"CCCCCC",
			"AAATTT",
			"AAATTT",
			"AAATTT",
			"TTGGAA",
			"TTGGAA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}

	@Test
	public void threeDistinctMatches(){
		String[] dna = {
			"ATGCGA",
			"CAGTGC",
			"TTATGT",
			"AGAAGG",
			"CCCCTA",
			"TCACTG"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert isMutant;
	}

	@Test
	public void intersectingMatches(){
		String[] dna = {
			"AATA",
			"TTTT",
			"AATA",
			"AATA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert isMutant;
	}
}
