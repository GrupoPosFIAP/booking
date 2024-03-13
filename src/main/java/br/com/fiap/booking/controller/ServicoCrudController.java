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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.booking.domain.opcionais.Servico;
import br.com.fiap.booking.dto.ServicoDto;
import br.com.fiap.booking.mapper.ServicoMapper;
import br.com.fiap.booking.service.ServicoCrudService;

@RestController
@RequestMapping("/servicos")
public class ServicoCrudController extends BaseCrudController<Servico, ServicoDto> {

    public ServicoCrudController(ServicoCrudService crudService, ServicoMapper mapper) {
        super(crudService, mapper);
    }

    @PostMapping
    public ResponseEntity<ServicoDto> create(@RequestBody ServicoDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDto> update(@RequestBody ServicoDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ServicoDto>> search(@RequestParam("search") String search) {
        return super.search(search);
    }

}
