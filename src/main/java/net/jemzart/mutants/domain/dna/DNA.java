package net.jemzart.mutants.domain.dna;

import net.jemzart.mutants.domain.dna.exceptions.InvalidDNAException;

public class DNA {
	private String[] dna;
	private int length;

	public DNA(String[] dna){
		length = dna.length;
		validate(dna);
		this.dna = dna;
	}

	public char get(int x, int y){
 		return dna[y].charAt(x);
	}

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
