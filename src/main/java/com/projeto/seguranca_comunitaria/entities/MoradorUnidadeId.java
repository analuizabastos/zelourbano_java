package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class MoradorUnidadeId implements Serializable {
    private Integer idMorador;
    private Integer idUnidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidadeId that)) return false;
        return Objects.equals(idMorador, that.idMorador) && Objects.equals(idUnidade, that.idUnidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMorador, idUnidade);
    }
}
