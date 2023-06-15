package com.claridoug.tccspring.repository;

import com.claridoug.tccspring.model.entity.Redator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedatorRepository extends JpaRepository<Redator,Long> {
}
