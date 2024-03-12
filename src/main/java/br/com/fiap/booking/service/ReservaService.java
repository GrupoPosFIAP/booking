package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.dto.ReservaDto;
import br.com.fiap.booking.domain.reservas.Reserva;
import br.com.fiap.booking.repository.QuartoRepository;
import br.com.fiap.booking.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public Reserva cadastrarReserva(ReservaDto reservaDto) {
        Quarto quarto = this.quartoRepository.findById(reservaDto.getIdQuarto())
                .orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado."));


        return this.reservaRepository.save(reservaDto.toEntity(quarto, Collections.emptyList(), Collections.emptyList()));
    }

}
