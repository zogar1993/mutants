package net.jemzart.mutants.unit.identifying;

import net.jemzart.mutants.domain.MutantIdentifier;
import org.junit.Test;

public class Horizontal {
	@Test
	public void oneIsNotEnough(){
		String[] dna = {
			"TTTT",
			"CCAA",
			"ACCA",
			"AACC"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}

	@Test
	public void twoAreEnough(){
		String[] dna = {
			"TTTT",
			"CCAA",
			"TTTT",
			"AACC"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert isMutant;
	}
}
