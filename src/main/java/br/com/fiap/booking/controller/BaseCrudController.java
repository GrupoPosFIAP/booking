package br.com.fiap.booking.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.mapper.BaseMapper;
import br.com.fiap.booking.service.BaseCrudService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseCrudController<E extends BaseEntity, DTO> {

    private final BaseCrudService<E> crudService;
    private final BaseMapper<E, DTO> mapper;

    public ResponseEntity<DTO> create(DTO dto) {
        var entity = mapper.toEntity(dto);
        var created = crudService.create(entity);
        return ResponseEntity.ok(mapper.toDto(created));
    }

    public ResponseEntity<DTO> read(Long id) {
        var entity = crudService.read(id);
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    public ResponseEntity<DTO> update(DTO data, Long id) {
        var entityData = mapper.toEntity(data);
        var updated = crudService.update(entityData, id);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    public ResponseEntity<Void> delete(Long id) {
        crudService.delete(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<DTO>> search(String... params) {
        var response = crudService
            .search(params)
            .stream()
            .map(mapper::toDto)
            .collect(toList());
        
        return ResponseEntity.ok(response);
    }
}
