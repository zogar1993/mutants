package net.jemzart.mutants.domain.ratio;

public class MutantStatistics {
	private int humans;
	private int mutants;


	/**
	 * adds 1 to human counter
	 */
	public void addHuman(){
		humans++;
	}

	/**
	 * adds 1 to mutant counter
	 */
	public void addMutant(){
		mutants++;
	}

	/**
	 * @return mutants ratio compared to humans. If there are no humans to compare to, returns null.
	 */
	public Double getMutantsRatio(){
		if(humans == 0) return null;
		return ((double)mutants) / ((double)humans);
	}

	/**
	 * @return amount of humans
	 */
	public int getHumanCount() {
		return humans;
	}

	/**
	 * @return amount of mutants
	 */
	public int getMutantCount() {
		return mutants;
	}
}
