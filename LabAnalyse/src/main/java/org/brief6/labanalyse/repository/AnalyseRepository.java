package org.brief6.labanalyse.repository;

import org.brief6.labanalyse.entites.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseRepository extends JpaRepository<Analyse,Long> {
}
