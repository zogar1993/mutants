package net.jemzart.mutants.entities;

import javax.persistence.*;

@Entity
public class DNAEntity {
	@Id
	@GeneratedValue
	private long id;

	@Column
	private boolean mutant;

	@Column
	private String raw;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isMutant() {
		return mutant;
	}

	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}
}
