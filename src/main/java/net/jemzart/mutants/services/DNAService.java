package net.jemzart.mutants.services;

import net.jemzart.mutants.domain.MutantIdentifier;
import net.jemzart.mutants.domain.ratio.MutantStatistics;
import net.jemzart.mutants.entities.DNAEntity;
import net.jemzart.mutants.repositories.DNARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DNAService {
	private DNARepository dnaRepository;

	public DNAService(DNARepository dnaRepository){
		this.dnaRepository = dnaRepository;
	}

	public boolean isMutant(String[] dna){
		boolean isMutant = MutantIdentifier.isMutant(dna);
		DNAEntity entity = new DNAEntity();
		entity.setMutant(isMutant);
		entity.setRaw(serialize(dna));
		dnaRepository.saveAndFlush(entity);
		return isMutant;
	}

	private String serialize(String[] dna){
		StringBuilder raw = new StringBuilder();
		for (String str : dna)
			raw.append(str);
		return raw.toString();
	}

	public MutantStatistics getStatistics(){
		List<DNAEntity> dnas = dnaRepository.findAll();
		MutantStatistics statistics = new MutantStatistics();

		dnas.forEach((dna) -> { if (dna.isMutant()) statistics.addMutant(); else statistics.addHuman(); });

		return statistics;
	}
}