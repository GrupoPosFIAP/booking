package br.com.fiap.booking.controller;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.dto.QuartoDto;
import br.com.fiap.booking.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @PostMapping
    public Quarto cadastrarQuarto(@RequestBody QuartoDto quartoDto) {
        return this.quartoService.cadastrarQuarto(quartoDto);
    }

    @GetMapping
    public List<Quarto> listarQuartos() {
        return this.quartoService.listarQuartos();
    }

}
