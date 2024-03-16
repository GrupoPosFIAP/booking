package br.com.fiap.booking.domain.dto;

import br.com.fiap.booking.domain.Predio;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QuartoReservaDto {

    private String idQuarto;
    private String nome;
    private String descricao;
    private String tipo;
    private Integer totalPessoas;
    private Integer quantidadeCamas;
    private List<String> moveis;
    private BigDecimal value;
    private Integer quantidadeBanheiros;
    private Integer quantidadeQuartos;
    private Long quartosDisponiveis;
    private Long quantidadeReservas;

    public Long getQuartosDisponiveis() {
       return this.quantidadeQuartos - this.quantidadeReservas;
    }

}

