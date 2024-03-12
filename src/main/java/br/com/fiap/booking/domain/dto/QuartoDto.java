package br.com.fiap.booking.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QuartoDto {

    private Long idPredio;
    private String tipo;
    private Integer totalPessoas;
    private Integer quantidadeCamas;
    private List<String> moveis;
    private BigDecimal value;
    private Integer quantidadeBanheiros;
    private Integer quantidadeQuartos;
}
