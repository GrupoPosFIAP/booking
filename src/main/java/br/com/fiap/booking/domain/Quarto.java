package br.com.fiap.booking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Quarto extends BaseEntity implements Produto {

    @ManyToOne(cascade = CascadeType.MERGE)
    private Predio predio;
    private Long numero;
    private String tipo;
    private Integer totalPessoas;
    private Integer quantidadeCamas;
    @ElementCollection
    private List<String> moveis;
    private BigDecimal value;
    private Integer quantidadeBanheiros;
    private Integer quantidadeQuartos;


}
