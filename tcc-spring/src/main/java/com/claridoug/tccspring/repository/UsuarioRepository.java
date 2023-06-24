package com.claridoug.tccspring.repository;

import com.claridoug.tccspring.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);

}
