package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.domain.dto.LocalidadeDto;
import br.com.fiap.booking.domain.dto.PredioDto;
import br.com.fiap.booking.repository.LocalidadeRepository;
import br.com.fiap.booking.repository.PredioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredioService {

    @Autowired
    private PredioRepository predioRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public Predio cadastrarPredio(PredioDto predioDto) {
        Localidade localidade = this.localidadeRepository.findById(predioDto.getIdLocalidade())
                .orElseThrow(() -> new EntityNotFoundException("Localidade não encontrada."));
        return this.predioRepository.save(predioDto.toEntity(localidade));
    }

}
