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

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.dto.PredioDto;
import br.com.fiap.booking.mapper.PredioMapper;
import br.com.fiap.booking.service.PredioCrudService;

@RestController
@RequestMapping("/predios")
public class PredioCrudController extends BaseCrudController<Predio, PredioDto> {

    public PredioCrudController(PredioCrudService crudService, PredioMapper mapper) {
        super(crudService, mapper);
    }

    @PostMapping
    public ResponseEntity<PredioDto> create(@RequestBody PredioDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PredioDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PredioDto> update(@RequestBody PredioDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<PredioDto>> search(@PathVariable("search") String search) {
        return super.search(search);
    }

}

