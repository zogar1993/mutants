package net.jemzart.mutants.domain.dna;

import net.jemzart.mutants.domain.dna.exceptions.InvalidDNAException;

/**
 * Holds a valid dna representation
 */
public class DNA {
	private String[] dna;
	private int length;

	/**
	 * constructs valid dna, when valid means its nitrogenous bases are C, G, T or A,
	 * and its width equals its height
	 *
	 * @param dna raw dna.
	 * @throws InvalidDNAException If dna is not valid.
	 */
	public DNA(String[] dna){
		length = dna.length;
		validate(dna);
		this.dna = dna;
	}

	/**
	 * @param x horizontal coordinate.
	 * @param y vertical coordinate.
	 * @return nitrogenous base at designated coordinates
	 */
	public char get(int x, int y){
 		return dna[y].charAt(x);
	}

	/**
	 * @return both the height and the width, since dna is square.
	 */
	public int length(){
		return length;
	}

	private void validate(String[] raw){
		for (String str : raw){
			if (str.length() != length) throw InvalidDNAException.create("DNA must be a square matrix", raw);
			for (int i = 0; i < length; i++) {
				char character = str.charAt(i);
				if (!isDnaNitrogenousBase(character))
					throw InvalidDNAException.create("'" + character + "' must be a DNA nitrogenous base", raw);
			}
		}
	}
	
	private static boolean isDnaNitrogenousBase(char character){
		return character == 'A' || character == 'G' || character == 'C' || character == 'T';
	}
}
