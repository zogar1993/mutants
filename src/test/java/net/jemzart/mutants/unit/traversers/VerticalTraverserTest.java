package net.jemzart.mutants.unit.traversers;

import net.jemzart.mutants.domain.dna.DNA;
import net.jemzart.mutants.domain.traversers.VerticalTraverser;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class VerticalTraverserTest {
	@Test
	public void fullScan(){
		DNA dna = new DNA(new String[]{"AC", "GT"});
		VerticalTraverser traverser = new VerticalTraverser(dna);

		//first line
		assertEquals(traverser.current(), 'A');
		assertTrue(traverser.advance(1));
		assertEquals(traverser.current(), 'G');
		assertFalse(traverser.advance(1));

		assertTrue(traverser.nextLine());

		//second line
		assertEquals(traverser.current(), 'C');
		assertTrue(traverser.advance(1));
		assertEquals(traverser.current(), 'T');
		assertFalse(traverser.advance(1));

		assertFalse(traverser.nextLine());
	}

	@Test
	public void retrieve() {
		DNA dna = new DNA(new String[]{"AC", "GT"});
		VerticalTraverser traverser = new VerticalTraverser(dna);

		traverser.advance(1);

		assertEquals(traverser.retrieve(-1), 'A');
	}
}
