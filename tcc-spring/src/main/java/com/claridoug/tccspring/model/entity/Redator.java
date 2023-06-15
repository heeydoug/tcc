package com.claridoug.tccspring.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "redator")
@Data
public class Redator extends Usuario {
    @OneToMany(mappedBy = "redator")
    private List<Artigo> artigosVinculados;

    public Redator() {
        this.setTipo("redator");
    }
}
