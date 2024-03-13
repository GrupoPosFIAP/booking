package br.com.fiap.booking.service;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.mapper.ReservaMapper;
import br.com.fiap.booking.repository.ReservaRepository;

@Service
public class ReservaCrudService extends BaseCrudService<Reserva> {

    public ReservaCrudService(ReservaRepository repository, ReservaMapper mapper) {
        super(repository, mapper);
    }

}
