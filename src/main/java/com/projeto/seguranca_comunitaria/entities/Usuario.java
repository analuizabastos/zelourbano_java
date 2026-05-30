package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_morador", unique = true)
    private Morador morador;

    @OneToOne
    @JoinColumn(name = "id_prestador", unique = true)
    private Prestador prestador;

    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_perfil_acesso")
    private PerfilAcesso perfilAcesso;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusSistema status;

    public Usuario() {}

    public Usuario(Morador morador, Prestador prestador, String login, String senha, PerfilAcesso perfilAcesso, StatusSistema status) {
        this.morador = morador;
        this.prestador = prestador;
        this.login = login;
        this.senha = senha;
        this.perfilAcesso = perfilAcesso;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Morador getMorador() { return morador; }
    public void setMorador(Morador morador) { this.morador = morador; }
    public Prestador getPrestador() { return prestador; }
    public void setPrestador(Prestador prestador) { this.prestador = prestador; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public PerfilAcesso getPerfilAcesso() { return perfilAcesso; }
    public void setPerfilAcesso(PerfilAcesso perfilAcesso) { this.perfilAcesso = perfilAcesso; }
    public StatusSistema getStatus() { return status; }
    public void setStatus(StatusSistema status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}