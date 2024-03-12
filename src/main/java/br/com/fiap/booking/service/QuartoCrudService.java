package br.com.fiap.booking.service;

import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.mapper.QuartoMapper;
import br.com.fiap.booking.repository.QuartoRepository;

@Component
public class QuartoCrudService extends BaseCrudService<Quarto> {
    
    public QuartoCrudService(
        QuartoRepository repository,
        QuartoMapper mapper
    ) {
        super(repository, mapper);
    }
}