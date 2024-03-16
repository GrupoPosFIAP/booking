package br.com.fiap.booking.domain.dto;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.Predio;
import lombok.Data;

@Data
public class PredioDto {

    private String nome;
    private Long idLocalidade;
    private String descricao;

    public Predio toEntity(Localidade localidade) {
        Predio predio = new Predio();
        predio.setLocalidade(localidade);
        predio.setDescricao(this.descricao);
        predio.setNome(this.nome);
        return predio;
    }

}
