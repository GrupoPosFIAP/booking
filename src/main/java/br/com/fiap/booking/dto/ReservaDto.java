package br.com.fiap.booking.dto;

import java.time.LocalDateTime;
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
public class ReservaDto extends BaseDto {

    private QuartoDto quarto;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private List<ItemDto> itens;
    private List<ServicoDto> servicos;
    private UsuarioDto cliente;
    private Integer totalPessoas;
}
