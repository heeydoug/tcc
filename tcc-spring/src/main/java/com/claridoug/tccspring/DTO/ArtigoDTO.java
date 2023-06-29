package com.claridoug.tccspring.DTO;

import com.claridoug.tccspring.model.entity.Cliente;
import com.claridoug.tccspring.model.entity.Redator;
import com.claridoug.tccspring.model.entity.Revisor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArtigoDTO {

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
