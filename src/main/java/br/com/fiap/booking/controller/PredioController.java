package br.com.fiap.booking.controller;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.domain.dto.PredioDto;
import br.com.fiap.booking.service.LocalidadeService;
import br.com.fiap.booking.service.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/predio")
public class PredioController {

    @Autowired
    private PredioService predioService;

    @PostMapping
    public Predio cadastrarPredio(@RequestBody PredioDto predioDto) {
        return this.predioService.cadastrarPredio(predioDto);
    }

}
