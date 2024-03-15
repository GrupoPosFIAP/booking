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

import br.com.fiap.booking.controller.specifications.UsuarioSpecification;
import br.com.fiap.booking.domain.Usuario;
import br.com.fiap.booking.dto.UsuarioDto;
import br.com.fiap.booking.mapper.UsuarioMapper;
import br.com.fiap.booking.service.UsuarioCrudService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioCrudController extends BaseCrudController<Usuario, UsuarioDto> {

    public UsuarioCrudController(UsuarioCrudService crudService, UsuarioMapper mapper) {
        super(crudService, mapper);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> search(UsuarioSpecification specs) {
        return super.search(specs);
    }

}
