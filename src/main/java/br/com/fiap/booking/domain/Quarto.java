package br.com.fiap.booking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Quarto extends BaseEntity implements Produto {

    @ManyToOne(cascade = CascadeType.ALL)
    private Predio predio;
    private String tipo;
    private Integer totalPessoas;
    private Integer quantidadeCamas;
    @ElementCollection
    private List<String> moveis;
    private BigDecimal value;
    private Integer quantidadeBanheiros;
    private Integer quantidadeQuartos;


}
