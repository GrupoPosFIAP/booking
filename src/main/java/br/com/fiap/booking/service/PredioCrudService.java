package br.com.fiap.booking.service;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.mapper.PredioMapper;
import br.com.fiap.booking.repository.PredioRepository;

@Service
public class PredioCrudService extends BaseCrudService<Predio> {

    public PredioCrudService(PredioRepository repository, PredioMapper mapper) {
        super(repository, mapper);
    }

}
