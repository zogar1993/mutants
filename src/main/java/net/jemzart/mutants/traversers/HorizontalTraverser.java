package net.jemzart.mutants.traversers;

import net.jemzart.mutants.dna.DNA;

public class HorizontalTraverser implements LineTraverser {
	private DNA dna;
	private int x = 0;
	private int y = 0;
	public HorizontalTraverser(DNA dna){
		this.dna = dna;
	}

	@Override
	public char current(){
		return dna.get(x, y);
	}

	@Override
	public char retrieve(int offset){
		return dna.get(x + offset, y);
	}

	@Override
	public boolean advance(int amount){
		x += amount;
		return x < dna.length();
	}

	@Override
	public boolean nextLine(){
		x = 0;
		return ++y < dna.length();
	}
}
