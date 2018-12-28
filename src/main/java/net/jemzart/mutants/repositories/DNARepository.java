package net.jemzart.mutants.repositories;

import net.jemzart.mutants.entities.DNAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNAEntity, Long> {

}