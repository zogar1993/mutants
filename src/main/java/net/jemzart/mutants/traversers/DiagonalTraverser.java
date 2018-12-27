package net.jemzart.mutants.traversers;

import net.jemzart.mutants.dna.DNA;

public class DiagonalTraverser implements LineTraverser {
	private DNA dna;
	private int initial_x;
	private int initial_y;
	private int x;
	private int y;

	public DiagonalTraverser(DNA dna) {
		this.dna = dna;
		initial_x = 0;
		initial_y = dna.length() - 1;
		x = initial_x;
		y = initial_y;
	}

	@Override
	public char current() {
		return dna.get(x, y);
	}

	@Override
	public char retrieve(int offset) {
		return dna.get(x + offset, y + offset);
	}

	@Override
	public boolean advance(int amount) {
		x += amount;
		y += amount;
		return x < dna.length() && y < dna.length();
	}

	@Override
	public boolean nextLine() {
		if (initial_y > 0) initial_y--;
		else initial_x++;
		if(initial_x >= dna.length()) return false;

		x = initial_x;
		y = initial_y;
		return y < dna.length();
	}
}