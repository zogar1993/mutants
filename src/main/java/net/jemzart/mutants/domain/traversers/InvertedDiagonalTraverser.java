package net.jemzart.mutants.domain.traversers;

import net.jemzart.mutants.domain.dna.DNA;

public class InvertedDiagonalTraverser implements LineTraverser {
	private DNA dna;
	private int initial_x;
	private int initial_y;
	private int x;
	private int y;

	public InvertedDiagonalTraverser(DNA dna) {
		this.dna = dna;
		initial_x = 0;
		initial_y = 0;
		x = initial_x;
		y = initial_y;
	}

	@Override
	public char current() {
		return dna.get(x, y);
	}

	@Override
	public char retrieve(int offset) {
		return dna.get(x - offset, y + offset);
	}

	@Override
	public boolean advance(int amount) {
		x -= amount;
		y += amount;
		return x >= 0 && y < dna.length();
	}

	@Override
	public boolean nextLine() {
		if (initial_x < dna.length() - 1) initial_x++;
		else initial_y++;
		if(initial_y >= dna.length()) return false;

		x = initial_x;
		y = initial_y;
		return y < dna.length();
}
}