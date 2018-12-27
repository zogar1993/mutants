package net.jemzart.mutants.domain.dna.exceptions;

public class InvalidDNAException extends RuntimeException {
	private String[] dna;

	private InvalidDNAException(String message, String[] dna) {
		super(message);
		this.dna = dna;
	}

	public String[] getDna() {
		return dna;
	}

	public static InvalidDNAException create(String message, String[] dna){
		return new InvalidDNAException(message, dna);
	}
}
