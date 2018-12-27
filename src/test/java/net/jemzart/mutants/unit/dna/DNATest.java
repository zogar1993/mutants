package net.jemzart.mutants.unit.dna;

import net.jemzart.mutants.domain.dna.DNA;
import net.jemzart.mutants.domain.dna.exceptions.InvalidDNAException;
import org.junit.Test;

public class DNATest {
	@Test
	public void simpleDna(){
		DNA dna = new DNA(new String []{"AC", "GT"});

		assert dna.get(0, 0) == 'A';
		assert dna.get(1, 0) == 'C';
		assert dna.get(0, 1) == 'G';
		assert dna.get(1, 1) == 'T';
	}

	@Test(expected = InvalidDNAException.class)
	public void nonSquareDna(){
		new DNA(new String []{"AC", "G"});
	}

	@Test(expected = InvalidDNAException.class)
	public void nonDnaNitrogenousBase(){
		new DNA(new String []{"F"});
	}
}
