package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

@Entity
@IdClass(MoradorUnidadeId.class)
public class MoradorUnidade {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_morador")
    private Morador morador;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusSistema status;

    @ManyToOne
    @JoinColumn(name = "id_perfil_acesso")
    private PerfilAcesso perfilAcesso;

    public MoradorUnidade() {
    }

    public MoradorUnidade(Morador morador, Unidade unidade, StatusSistema status, PerfilAcesso perfilAcesso) {
        this.morador = morador;
        this.unidade = unidade;
        this.status = status;
        this.perfilAcesso = perfilAcesso;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public StatusSistema getStatus() {
        return status;
    }

    public void setStatus(StatusSistema status) {
        this.status = status;
    }

    public com.projeto.seguranca_comunitaria.entities.PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(com.projeto.seguranca_comunitaria.entities.PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
}