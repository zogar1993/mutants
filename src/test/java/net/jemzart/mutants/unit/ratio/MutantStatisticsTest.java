package net.jemzart.mutants.unit.ratio;

import net.jemzart.mutants.domain.ratio.MutantStatistics;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MutantStatisticsTest {

	@Test
	public void zeroData(){
		MutantStatistics mutantStatistics = new MutantStatistics();

		assertNull(mutantStatistics.getRatio());
	}

	@Test
	public void none(){
		MutantStatistics mutantStatistics = new MutantStatistics();

		mutantStatistics.addHuman();
		mutantStatistics.getRatio();

		assertEquals(mutantStatistics.getRatio(), 0, 0);
	}

	@Test
	public void all(){
		MutantStatistics mutantStatistics = new MutantStatistics();

		mutantStatistics.addMutant();
		mutantStatistics.getRatio();

		assertNull(mutantStatistics.getRatio());
	}

	@Test
	public void half(){
		MutantStatistics mutantStatistics = new MutantStatistics();

		mutantStatistics.addHuman();
		mutantStatistics.addHuman();
		mutantStatistics.addMutant();

		assertEquals(mutantStatistics.getRatio(), 0.5, 0);
	}

	@Test
	public void equal(){
		MutantStatistics mutantStatistics = new MutantStatistics();

		mutantStatistics.addHuman();
		mutantStatistics.addMutant();

		assertEquals(mutantStatistics.getRatio(), 1, 0);
	}

	@Test
	public void twice(){
		MutantStatistics mutantStatistics = new MutantStatistics();

		mutantStatistics.addHuman();
		mutantStatistics.addMutant();
		mutantStatistics.addMutant();

		assertEquals(mutantStatistics.getRatio(), 2, 0);
	}
}
