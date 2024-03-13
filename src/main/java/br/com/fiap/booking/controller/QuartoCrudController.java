package br.com.fiap.booking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.booking.controller.specifications.QuartoSpecification;
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.dto.QuartoDto;
import br.com.fiap.booking.mapper.QuartoMapper;
import br.com.fiap.booking.service.QuartoCrudService;

@RestController
@RequestMapping("/quartos")
public class QuartoCrudController
        extends BaseCrudController<Quarto, QuartoDto> {

    public QuartoCrudController(
            QuartoCrudService service,
            QuartoMapper mapper) {
        super(service, mapper);
    }

    @PostMapping
    public ResponseEntity<QuartoDto> create(@RequestBody QuartoDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDto> update(@RequestBody QuartoDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<QuartoDto>> search(QuartoSpecification specs) {
        return super.search(specs);
    }
}
