package com.claridoug.tccspring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "usuario")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    @Column(name = "tipo")
    private String tipo;


}
