package br.com.fiap.booking.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadeDto extends BaseDto {

    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private List<String> amenidades;
}
