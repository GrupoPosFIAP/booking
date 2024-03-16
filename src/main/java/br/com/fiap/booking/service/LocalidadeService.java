package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.dto.LocalidadeDto;
import br.com.fiap.booking.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public Localidade cadastrarLocalidade(LocalidadeDto localidadeDto) {
        return this.localidadeRepository.save(localidadeDto.toEntity());
    }

}
