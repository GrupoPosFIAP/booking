package br.com.fiap.booking.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Quarto extends BaseEntity implements Produto {

    @ManyToOne
    private Predio predio;
    private String tipo;
    private Integer totalPessoas;
    private Integer quantidadeCamas;
    private List<String> moveis;
    private BigDecimal value;
    private Integer quantidadeBanheiros;
    private Integer quantidadeQuartos;


}
