package net.jemzart.mutants.domain.traversers;

public interface LineTraverser {
	char current();
	char retrieve(int offset);
	boolean advance(int amount);
	boolean nextLine();
}
