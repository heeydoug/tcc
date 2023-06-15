package com.claridoug.tccspring.repository;

import com.claridoug.tccspring.model.entity.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo,Long> {
}
