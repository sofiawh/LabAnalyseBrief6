package org.brief6.labanalyse.repository;

import org.brief6.labanalyse.entites.Test;
import org.brief6.labanalyse.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
}
