package com.claridoug.tccspring.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cliente")
@Data
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente")
    private List<Artigo> artigosVinculados;

    public Cliente() {
        this.setTipo("cliente");
    }
}
