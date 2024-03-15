package br.com.fiap.booking.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.controller.specifications.QuartoSpecification;
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.exception.DataNotFoundException;
import br.com.fiap.booking.mapper.QuartoMapper;
import br.com.fiap.booking.repository.QuartoRepository;

@ExtendWith(MockitoExtension.class)
public class QuartoCrudServiceTest {

    @InjectMocks
    private QuartoCrudService service;

    @Mock
    private QuartoRepository repository;

    private QuartoMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new QuartoMapper(new ModelMapper());
        service = new QuartoCrudService(repository, mapper);
    }

    @Test
    void create() {
        when(repository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        var servico = new Quarto();

        var response = service.create(servico);

        assertNotNull(response);
    }

    @Test
    void read() {
        when(repository.findById(any())).thenReturn(Optional.of(new Quarto()));

        var response = service.read(1L);

        assertNotNull(response);

    }

    @Test
    void readWithoutData() {
        when(repository.findById(any())).thenThrow(new DataNotFoundException());

        assertThrows(DataNotFoundException.class, () -> service.read(1L));
    }

    @Test
    void update() {

        when(repository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        when(repository.findById(any())).thenReturn(Optional.of(new Quarto()));

        var response = service.update(new Quarto(), 1L);

        assertNotNull(response);
    }

    @Test
    void updateWithNoData() {
        when(repository.findById(any())).thenThrow(new DataNotFoundException());
        
        assertThrows(DataNotFoundException.class, () -> service.update(new Quarto(), 1L));
    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(any());

        assertDoesNotThrow(() -> service.delete(1L));
    }

    @Test
    void search() {
        when(repository.findAll(any(QuartoSpecification.class)))
        .thenReturn(List.of(new Quarto()));

        var specs = mock(QuartoSpecification.class);

        assertNotNull(service.search(specs));
    }
}
