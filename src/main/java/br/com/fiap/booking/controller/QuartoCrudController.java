package br.com.fiap.booking.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.booking.api.QuartoApi;
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.dto.QuartoDto;
import br.com.fiap.booking.mapper.QuartoMapper;
import br.com.fiap.booking.service.QuartoCrudService;


@RestController
public class QuartoCrudController 
    extends BaseCrudController<Quarto, QuartoDto> 
    implements QuartoApi {

    public QuartoCrudController(
            QuartoCrudService service,
            QuartoMapper mapper) {
        super(service, mapper);
    }
}
