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

import br.com.fiap.booking.domain.opcionais.Item;
import br.com.fiap.booking.dto.ItemDto;
import br.com.fiap.booking.mapper.ItemMapper;
import br.com.fiap.booking.service.ItemCrudService;

@RestController
@RequestMapping("/itens")
public class ItemCrudController extends BaseCrudController<Item, ItemDto> {

    public ItemCrudController(ItemCrudService crudService, ItemMapper mapper) {
        super(crudService, mapper);
    }

    @PostMapping
    public ResponseEntity<ItemDto> create(@RequestBody ItemDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> update(@RequestBody ItemDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> search(@PathVariable("search") String search) {
        return super.search(search);
    }

}
