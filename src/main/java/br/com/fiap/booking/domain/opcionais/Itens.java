package br.com.fiap.booking.domain.opcionais;

import java.math.BigDecimal;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Itens extends BaseEntity implements Produto {

    @ManyToOne
    private Localidade localidade;
    private BigDecimal value;
    private Integer quantidade;

}