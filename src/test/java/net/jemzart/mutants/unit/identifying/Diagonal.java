package net.jemzart.mutants.unit.identifying;

import net.jemzart.mutants.domain.MutantIdentifier;
import org.junit.Test;

public class Diagonal {
	@Test
	public void oneIsNotEnough(){

		String[] dna = {
			"TCCAA",
			"CTGGA",
			"CGTGC",
			"AGGTC",
			"AACCA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;

	}

	@Test
	public void twoAreEnough(){
		String[] dna = {
			"ATAAA",
			"TCTAA",
			"ATCTA",
			"AATCT",
			"AAATA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert isMutant;
	}
}
