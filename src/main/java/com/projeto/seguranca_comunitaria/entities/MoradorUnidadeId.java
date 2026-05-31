package com.projeto.seguranca_comunitaria.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class MoradorUnidadeId implements Serializable {
    private Integer morador;
    private Integer unidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidadeId that)) return false;
        return Objects.equals(morador, that.morador) && Objects.equals(unidade, that.unidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(morador, unidade);
    }
}
