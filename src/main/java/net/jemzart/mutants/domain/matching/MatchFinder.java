package net.jemzart.mutants.domain.matching;

import net.jemzart.mutants.domain.traversers.LineTraverser;

public class MatchFinder {
	private byte found = 0;
	private LineTraverser traverser;

	public boolean scan(LineTraverser traverser){
		this.traverser = traverser;
		do {
			if(scanLine()) return true;//The search is over, mutant pattern found.
		} while (traverser.nextLine());
		return false;
	}

	private boolean scanLine(){
		if (!traverser.advance(1)) return false;
		char last = traverser.current();

		//Since I must find 4 in a row, advancing 2 at a time makes sure I do not miss a match.
		//The amount of operations is roughly halved in an optimistic use case.
		while (traverser.advance(2)){
			char current = traverser.current();
			if (current == last){
				if (current == traverser.retrieve(-1)){//check between current and last one
					if (current == traverser.retrieve(-3)){//check before the just found three in a row
						if (addMatchFound(current)) return true;
					} else {
						if (traverser.advance(1)){//not end of line
							if (current == traverser.current()){//check after the just found three in a row
								if (addMatchFound(current)) return true;
							} else {
								traverser.advance(1);//skip first character after sequence
							}
						}
					}
				}
			}
			if(isOffBounds()) break;
			last = traverser.current();
		}
		return false;
	}

	private boolean addMatchFound(char value){
		found++;
		if (theSearchIsOver()) return true;//mutant pattern found.
		skip(value);
		traverser.advance(1);//skip first character after match
		return false;
	}

	private boolean isOffBounds(){
		return !traverser.advance(0);
	}

	private boolean theSearchIsOver(){
		return found > 1;
	}

	private void skip(char value){
		while (traverser.advance(1)){
			if (traverser.current() != value) return;
		}
	}
}
