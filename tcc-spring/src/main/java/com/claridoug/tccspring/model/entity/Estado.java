package com.claridoug.tccspring.model.entity;

import com.claridoug.tccspring.model.enums.EstadoArtigo;
import jakarta.persistence.*;

@Entity
public class Estado {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoArtigo status;
}
