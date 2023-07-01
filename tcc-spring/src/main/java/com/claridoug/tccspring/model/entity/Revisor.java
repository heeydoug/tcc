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
@Table(name = "revisor")
@Data
public class Revisor extends Usuario {

    @OneToMany(mappedBy = "revisor")
    private List<Artigo> artigosVinculados;

    public Revisor() {
        super();
        super.setTipo("revisor");
    }
}
