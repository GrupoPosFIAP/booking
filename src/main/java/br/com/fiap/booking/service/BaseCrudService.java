package br.com.fiap.booking.service;

import java.util.Collections;
import java.util.List;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.exception.DataNotFoundException;
import br.com.fiap.booking.mapper.BaseMapper;
import br.com.fiap.booking.repository.BaseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public abstract class BaseCrudService<E extends BaseEntity> {

    private final BaseRepository<E> repository;
    private final BaseMapper<E, ?> mapper;

    public E create(E entity) {
        log.info("Salvando dados");
        return repository.save(entity);
    }

    public E read(Long id) {
        log.info("Obtendo dados");
        return repository
            .findById(id)
            .orElseThrow(DataNotFoundException::new);
    }

    public E update(E data, Long id) {
        log.info("Atualizando dados. id: {}", id);
        var outdated = repository
            .findById(id)
            .orElseThrow(DataNotFoundException::new);
        
        return mapper.mapping(data, outdated);

    }

    public void delete(Long id) {
        log.info("Deletando dados. id: {}", id);
        repository.deleteById(id);
        log.info("Dado deletado com sucesso: id: {}", id);
    }

    public List<E> search(String... params) {
        return Collections.emptyList();
    }
}
