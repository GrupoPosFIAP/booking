package br.com.fiap.booking.domain.opcionais;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.Produto;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Servicos extends BaseEntity implements Produto {

    private Localidade localidade;
    private BigDecimal value;
    private Integer quantidade;

}
