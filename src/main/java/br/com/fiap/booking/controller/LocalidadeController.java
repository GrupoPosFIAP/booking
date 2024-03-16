package br.com.fiap.booking.controller;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.dto.LocalidadeDto;
import br.com.fiap.booking.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService localidadeService;

    @PostMapping
    public Localidade cadastrarLocalidade(@RequestBody LocalidadeDto localidadeDto) {
        return this.localidadeService.cadastrarLocalidade(localidadeDto);
    }

}
