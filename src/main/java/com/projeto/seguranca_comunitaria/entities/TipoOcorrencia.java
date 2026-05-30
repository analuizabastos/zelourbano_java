package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo_ocorrencia")
public class TipoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_ocorrencia")
    private Integer id;

    @Column(name = "tipos", nullable = false, length = 100)
    private String tipo;

    public TipoOcorrencia() {
    }

    public TipoOcorrencia(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
