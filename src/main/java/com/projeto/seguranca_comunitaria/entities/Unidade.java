package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "unidade")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidade")
    private Integer id;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Column(name = "area_lote")
    private BigDecimal areaLote;

    @ManyToOne
    @JoinColumn(name = "id_comunidade")
    private Comunidade comunidade;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusSistema status;

    public Unidade() {
    }

    public Unidade(BigDecimal latitude, BigDecimal longitude, BigDecimal areaLote, Comunidade idComunidade, StatusSistema Status) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaLote = areaLote;
        this.comunidade = idComunidade;
        this.status = Status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getAreaLote() {
        return areaLote;
    }

    public void setAreaLote(BigDecimal areaLote) {
        this.areaLote = areaLote;
    }

    public Comunidade getIdComunidade() {
        return comunidade;
    }

    public void setIdComunidade(Comunidade idComunidade) {
        this.comunidade = idComunidade;
    }

    public StatusSistema getStatus() {
        return status;
    }

    public void setIdStatus(StatusSistema Status) {
        this.status = Status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unidade unidade)) return false;
        return Objects.equals(getId(), unidade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
