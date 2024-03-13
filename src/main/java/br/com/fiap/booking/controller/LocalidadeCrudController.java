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

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.dto.LocalidadeDto;
import br.com.fiap.booking.mapper.LocalidadeMapper;
import br.com.fiap.booking.service.LocalidadeCrudService;

@RestController
@RequestMapping("/localidades")
public class LocalidadeCrudController extends BaseCrudController<Localidade, LocalidadeDto> {

    public LocalidadeCrudController(LocalidadeCrudService crudService, LocalidadeMapper mapper) {
        super(crudService, mapper);
    }

    @PostMapping
    public ResponseEntity<LocalidadeDto> create(@RequestBody LocalidadeDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalidadeDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalidadeDto> update(@RequestBody LocalidadeDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<LocalidadeDto>> search(@PathVariable("search") String search) {
        return super.search(search);
    }

}
