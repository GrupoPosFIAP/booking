package br.com.fiap.booking.dto;

import java.math.BigDecimal;

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
public class ServicoDto extends BaseDto {

    private LocalidadeDto localidade;
    private BigDecimal value;
    private Integer quantidade;
}
