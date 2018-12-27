package net.jemzart.mutants.traversers;

import net.jemzart.mutants.dna.DNA;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class DiagonalTraverserTest {

	@Test
	public void fullScan(){
		DNA dna = new DNA(new String[]{"AC", "GT"});
		DiagonalTraverser traverser = new DiagonalTraverser(dna);

		//first line
		assertEquals(traverser.current(), 'G');
		assertFalse(traverser.advance(1));

		assertTrue(traverser.nextLine());

		//second line
		assertEquals(traverser.current(), 'A');
		assertTrue(traverser.advance(1));
		assertEquals(traverser.current(), 'T');
		assertFalse(traverser.advance(1));

		assertTrue(traverser.nextLine());

		//third line
		assertEquals(traverser.current(), 'C');
		assertFalse(traverser.advance(1));

		assertFalse(traverser.nextLine());
	}

	@Test
	public void retrieve() {
		DNA dna = new DNA(new String[]{"AC", "GT"});
		DiagonalTraverser traverser = new DiagonalTraverser(dna);

		traverser.nextLine();
		traverser.advance(1);

		assertEquals(traverser.retrieve(-1), 'A');
	}
}
