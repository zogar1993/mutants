package net.jemzart.mutants.domain.traversers;

import net.jemzart.mutants.domain.dna.DNA;

public class VerticalTraverser implements LineTraverser {
	private DNA dna;
	private int x = 0;
	private int y = 0;
	public VerticalTraverser(DNA dna){
		this.dna = dna;
	}

	@Override
	public char current(){
		return dna.get(x, y);
	}

	@Override
	public char retrieve(int offset){
		return dna.get(x, y + offset);
	}

	@Override
	public boolean advance(int amount){
		y += amount;
		return y < dna.length();
	}

	@Override
	public boolean nextLine(){
		y = 0;
		return ++x < dna.length();
	}
}
