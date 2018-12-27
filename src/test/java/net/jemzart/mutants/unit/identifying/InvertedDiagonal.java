package net.jemzart.mutants.unit.identifying;

import net.jemzart.mutants.domain.MutantIdentifier;
import org.junit.Test;

public class InvertedDiagonal {
	@Test
	public void oneIsNotEnough(){
		String[] dna = {
			"AACCT",
			"AGGTC",
			"CGTGC",
			"CTGGA",
			"ACCAA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;

	}

	@Test
	public void twoAreEnough(){
		String[] dna = {
			"AAATA",
			"AATCT",
			"ATCTA",
			"TCTAA",
			"ATAAA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert isMutant;
	}
}
