package net.jemzart.mutants.identifying;

import net.jemzart.mutants.MutantIdentifier;
import org.junit.Test;

public class Vertical {
	@Test
	public void oneIsNotEnough(){
		String[] dna = {
			"TAAC",
			"TACC",
			"TCCA",
			"TCAA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;

	}

	@Test
	public void twoAreEnough(){
		String[] dna = {
			"TATC",
			"TATC",
			"TCTA",
			"TCTA"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert isMutant;
	}
}
