package br.com.fiap.booking.dto;

import java.time.LocalDateTime;

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
    private LocalDateTime inicioReserva;
    private LocalDateTime fimReserva;
}
