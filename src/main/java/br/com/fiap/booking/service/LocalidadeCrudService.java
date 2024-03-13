package br.com.fiap.booking.service;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.mapper.LocalidadeMapper;
import br.com.fiap.booking.repository.LocalidadeRepository;

@Service
public class LocalidadeCrudService extends BaseCrudService<Localidade> {

    public LocalidadeCrudService(
            LocalidadeRepository repository,
            LocalidadeMapper mapper) {
        super(repository, mapper);
    }

}
