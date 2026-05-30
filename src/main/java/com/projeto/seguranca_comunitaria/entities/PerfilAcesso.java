package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "perfil_acesso")
public class PerfilAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil_acesso")
    private Integer id;

    @Column(name = "nm_perfil_acesso", nullable = false, length = 100)
    private String nome;

    public PerfilAcesso() {
    }

    public PerfilAcesso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
