package net.jemzart.mutants.domain.traversers;

public interface LineTraverser {
	/**
	 * @return character at current position.
	 */
	char current();

	/**
	 * Retrieves character without altering current position.
	 *
	 * @param offset distance from current position.
	 * @return character at offset distance from current position.
	 */
	char retrieve(int offset);

	/**
	 * Alters current position by moving the designated amount on current line.
	 *
	 * @param amount to be moved from current position.
	 * @return false if is off bounds.
	 */
	boolean advance(int amount);

	/**
	 * Moves to the next line.
	 *
	 * @return false if there were no more lines to move to.
	 */
	boolean nextLine();
}
