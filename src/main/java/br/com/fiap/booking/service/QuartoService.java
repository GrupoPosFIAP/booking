package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.dto.QuartoDto;
import br.com.fiap.booking.repository.PredioRepository;
import br.com.fiap.booking.repository.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private PredioRepository predioRepository;

    @Transactional
    public Quarto cadastrarQuarto(QuartoDto quartoDto) {
        Predio predio = this.predioRepository.findById(quartoDto.getIdPredio())
                .orElseThrow(() -> new EntityNotFoundException("Localidade não encontrada."));
        return this.quartoRepository.save(quartoDto.toEntity(predio));
    }

    public List<Quarto> listarQuartos() {
        return this.quartoRepository.findAll();
    }

}
