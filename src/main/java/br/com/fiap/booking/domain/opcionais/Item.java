package br.com.fiap.booking.domain.opcionais;

import java.math.BigDecimal;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.Produto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity implements Produto {

    @ManyToOne(cascade = CascadeType.MERGE)
    private Localidade localidade;
    private BigDecimal value;
    private Integer quantidade;

}