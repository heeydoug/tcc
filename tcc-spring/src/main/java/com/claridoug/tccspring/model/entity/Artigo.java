package com.claridoug.tccspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "artigo")
public class Artigo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Column(name = "conteudo", nullable = false)
    private String conteudo;
    @Column(name = "palavra_chave", nullable = false)
    private String palavraChave;
    @Column(name = "id_pasta_drive", nullable = false)
    private String idPastaDrive;
    @Column(name = "id_documento_drive", nullable = false)
    private String idDocumentoDrive;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_revisor")
    private Revisor revisor;
    @ManyToOne
    @JoinColumn(name = "id_redator")
    private Redator redator;

}
