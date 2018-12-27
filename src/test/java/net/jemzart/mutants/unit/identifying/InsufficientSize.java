package net.jemzart.mutants.unit.identifying;

import net.jemzart.mutants.domain.MutantIdentifier;
import org.junit.Test;

public class InsufficientSize {
	@Test
	public void size0(){
		String[] dna = {};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}

	@Test
	public void size1(){
		String[] dna = {"T"};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}

	@Test
	public void size2(){
		String[] dna = {
			"TT",
			"TT"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}

	@Test
	public void size3(){
		String[] dna = {
			"TTT",
			"TTT",
			"TTT"
		};
		boolean isMutant = MutantIdentifier.isMutant(dna);
		assert !isMutant;
	}
}
