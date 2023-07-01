package com.claridoug.tccspring.model.enums;

public enum EstadoArtigo {
    ABERTO (1, "ABERTO"),
    EM_EDICAO (2, "EM_EDICAO"),
    EM_REVISAO (3, "EM_REVISAO"),
    REVISADO (4, "REVISADO"),
    ACEITO (5, "ACEITO"),
    CANCELADO (6, "CANCELADO");

    private Integer codigo;
    private String descricao;

    private EstadoArtigo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoArtigo toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(EstadoArtigo art : EstadoArtigo.values()){
            if(cod.equals(art.getCodigo())){
                return art;
            }
        }

        throw new IllegalArgumentException("Estado de Artigo Invalido!");
    }
}
