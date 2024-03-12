package br.com.fiap.booking.domain.dto;

import br.com.fiap.booking.domain.Localidade;
import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.List;

@Data
public class LocalidadeDto {
    private String nome;
    private String descricao;
    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private List<String> amenidades;

    public Localidade toEntity() {
        Localidade localidade = new Localidade();
        localidade.setAmenidades(this.amenidades);
        localidade.setRua(this.rua);
        localidade.setCep(this.cep);
        localidade.setPais(this.pais);
        localidade.setEstado(this.estado);
        localidade.setCidade(this.cidade);
        localidade.setDescricao(this.descricao);
        localidade.setNome(this.nome);
        return localidade;
    }
}
