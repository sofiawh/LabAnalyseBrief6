package org.brief6.labanalyse.repository;

import org.brief6.labanalyse.entites.Planification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationRepository extends JpaRepository<Planification,Long> {
}
