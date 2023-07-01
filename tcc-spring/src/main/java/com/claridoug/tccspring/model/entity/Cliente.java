package com.claridoug.tccspring.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "cliente")
@Data
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente")
    private List<Artigo> artigosVinculados;

    public Cliente() {
        super();
        super.setTipo("cliente");
    }
}
