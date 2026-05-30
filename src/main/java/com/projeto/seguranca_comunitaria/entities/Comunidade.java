package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "comunidade")
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunidade")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @Column(name = "razao_social", length = 200)
    private String razaoSocial;

    @Column(name = "nome_fantasia", length = 200)
    private String nomeFantasia;

    @Column(name = "inscricao_estadual", length = 14)
    private String inscricaoEstadual;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "quantidade_de_lotes", nullable = false)
        private Integer lotes;

    @Column(name = "area_total", nullable = false)
    private BigDecimal areaTotal;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "doc_identificacao", length = 255)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusSistema Status;

    public Comunidade() {
    }

    public Comunidade(String nome, String cnpj, String razaoSocial, String nomeFantasia, String inscricaoEstadual, String email, Integer lotes, BigDecimal areaTotal, String observacoes, String documento, StatusSistema Status) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.email = email;
        this.lotes = lotes;
        this.areaTotal = areaTotal;
        this.observacoes = observacoes;
        this.documento = documento;
        this.Status = Status;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLotes() {
        return lotes;
    }

    public void setLotes(Integer lotes) {
        this.lotes = lotes;
    }

    public BigDecimal getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(BigDecimal areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public StatusSistema getIdStatus() {
        return Status;
    }

    public void setIdStatus(StatusSistema idStatus) {
        this.Status = idStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comunidade that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
