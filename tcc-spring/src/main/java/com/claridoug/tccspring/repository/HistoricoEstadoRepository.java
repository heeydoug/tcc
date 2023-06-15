package com.claridoug.tccspring.repository;

import com.claridoug.tccspring.model.entity.HistoricoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoEstadoRepository extends JpaRepository<HistoricoEstado,Long> {
}
