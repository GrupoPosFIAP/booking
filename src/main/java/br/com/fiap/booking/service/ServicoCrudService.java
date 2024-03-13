package br.com.fiap.booking.service;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.opcionais.Servico;
import br.com.fiap.booking.mapper.ServicoMapper;
import br.com.fiap.booking.repository.ServicoRepository;

@Service
public class ServicoCrudService extends BaseCrudService<Servico> {

    public ServicoCrudService(ServicoRepository repository, ServicoMapper mapper) {
        super(repository, mapper);
    }

}
