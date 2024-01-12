package org.brief6.labanalyse.repository;

import org.brief6.labanalyse.entites.Reactif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveRepository extends JpaRepository<Reactif,Long> {
}
