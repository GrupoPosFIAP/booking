package br.com.fiap.booking.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva extends BaseEntity {

    @ManyToOne
    private Quarto quarto;
    private LocalDateTime inicioReserva;
    private LocalDateTime fimReserva;
}
