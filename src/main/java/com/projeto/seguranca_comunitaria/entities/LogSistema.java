package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_sistema")
public class LogSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "operacao", nullable = false, length = 100)
    private String operacao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public LogSistema() {}

    public LogSistema(Usuario usuario, String operacao, LocalDateTime dataHora) {
        this.usuario = usuario;
        this.operacao = operacao;
        this.dataHora = dataHora;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getOperacao() { return operacao; }
    public void setOperacao(String operacao) { this.operacao = operacao; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}