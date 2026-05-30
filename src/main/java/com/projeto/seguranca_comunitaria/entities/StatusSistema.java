package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "status_sistema")
public class StatusSistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Integer id;

    @Column(name = "nm_status", nullable = false, length = 100)
    private String nome;

    public StatusSistema() {}
    public StatusSistema(Integer id, String nome) {
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
