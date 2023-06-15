package com.claridoug.tccspring.repository;

import com.claridoug.tccspring.model.entity.Revisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisorRepository extends JpaRepository<Revisor,Long> {
}
