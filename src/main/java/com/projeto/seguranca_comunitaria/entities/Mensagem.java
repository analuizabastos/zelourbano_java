package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensagem")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_ocorrencia", nullable = false)
    private Ocorrencia ocorrencia;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "texto", nullable = false)
    private String texto;

    @Column(name = "midia", length = 255)
    private String midia;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio;

    public Mensagem() {}

    public Mensagem(Ocorrencia ocorrencia, Usuario usuario, String texto, String midia, LocalDateTime dataEnvio) {
        this.ocorrencia = ocorrencia;
        this.usuario = usuario;
        this.texto = texto;
        this.midia = midia;
        this.dataEnvio = dataEnvio;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Ocorrencia getOcorrencia() { return ocorrencia; }
    public void setOcorrencia(Ocorrencia ocorrencia) { this.ocorrencia = ocorrencia; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public String getMidia() { return midia; }
    public void setMidia(String midia) { this.midia = midia; }
    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
}