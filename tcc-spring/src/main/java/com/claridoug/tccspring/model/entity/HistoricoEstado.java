package com.claridoug.tccspring.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistoricoEstado {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_alteracao", nullable = false)
    private LocalDate dataAlteracao = LocalDate.now();
    @Column(name = "observacao", nullable = false)
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "id_artigo")
    private Artigo artigo;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
