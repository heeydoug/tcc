package com.claridoug.tccspring.model.entity;

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
