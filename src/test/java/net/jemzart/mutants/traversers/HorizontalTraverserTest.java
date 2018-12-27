package net.jemzart.mutants.traversers;

import net.jemzart.mutants.dna.DNA;
import org.junit.Test;

import static org.junit.Assert.*;

public class HorizontalTraverserTest {
	@Test
	public void fullScan(){
		DNA dna = new DNA(new String[]{"AC", "GT"});
		HorizontalTraverser traverser = new HorizontalTraverser(dna);

		//first line
		assertEquals(traverser.current(), 'A');
		assertTrue(traverser.advance(1));
		assertEquals(traverser.current(), 'C');
		assertFalse(traverser.advance(1));

		assertTrue(traverser.nextLine());

		//second line
		assertEquals(traverser.current(), 'G');
		assertTrue(traverser.advance(1));
		assertEquals(traverser.current(), 'T');
		assertFalse(traverser.advance(1));

		assertFalse(traverser.nextLine());
	}

	@Test
	public void retrieve() {
		DNA dna = new DNA(new String[]{"AC", "GT"});
		HorizontalTraverser traverser = new HorizontalTraverser(dna);

		traverser.advance(1);

		assertEquals(traverser.retrieve(-1), 'A');
	}
}
