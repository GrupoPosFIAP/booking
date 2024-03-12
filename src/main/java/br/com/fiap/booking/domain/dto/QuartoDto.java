package br.com.fiap.booking.domain.dto;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.domain.Quarto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QuartoDto {

    private Long idPredio;
    private String nome;
    private String descricao;
    private String tipo;
    private Integer totalPessoas;
    private Integer quantidadeCamas;
    private List<String> moveis;
    private BigDecimal value;
    private Integer quantidadeBanheiros;
    private Integer quantidadeQuartos;

    public Quarto toEntity(Predio predio) {
        Quarto quarto = new Quarto();
        quarto.setNome(this.nome);
        quarto.setDescricao(this.descricao);
        quarto.setPredio(predio);
        quarto.setTipo(this.tipo);
        quarto.setTotalPessoas(this.totalPessoas);
        quarto.setQuantidadeCamas(this.quantidadeCamas);
        quarto.setMoveis(this.moveis);
        quarto.setValue(this.value);
        quarto.setQuantidadeBanheiros(this.quantidadeBanheiros);
        quarto.setQuantidadeQuartos(this.quantidadeQuartos);
        return quarto;
    }

}
