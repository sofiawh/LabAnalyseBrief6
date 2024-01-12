package org.brief6.labanalyse.repository;

import org.brief6.labanalyse.entites.Echantillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchantillonRepository extends JpaRepository<Echantillon,Long> {
}
