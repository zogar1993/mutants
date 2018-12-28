package net.jemzart.mutants.domain.ratio;

public class MutantStatistics {
	private int humans;
	private int mutants;

	public void addHuman(){
		humans++;
	}

	public void addMutant(){
		mutants++;
	}

	public Double getRatio(){
		if(humans == 0) return null;
		return ((double)mutants) / ((double)humans);
	}

	public int getHumanCount() {
		return humans;
	}

	public int getMutantCount() {
		return mutants;
	}
}
