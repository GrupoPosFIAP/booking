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

import br.com.fiap.booking.controller.specifications.ServicoSpecification;
import br.com.fiap.booking.domain.opcionais.Servico;
import br.com.fiap.booking.exception.DataNotFoundException;
import br.com.fiap.booking.mapper.ServicoMapper;
import br.com.fiap.booking.repository.ServicoRepository;

@ExtendWith(MockitoExtension.class)
public class ServicoCrudServiceTest {

    @InjectMocks
    private ServicoCrudService service;

    @Mock
    private ServicoRepository repository;

    private ServicoMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new ServicoMapper(new ModelMapper());
        service = new ServicoCrudService(repository, mapper);
    }

    @Test
    void create() {
        when(repository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        var servico = new Servico();

        var response = service.create(servico);

        assertNotNull(response);
    }

    @Test
    void read() {
        when(repository.findById(any())).thenReturn(Optional.of(new Servico()));

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

        when(repository.findById(any())).thenReturn(Optional.of(new Servico()));

        var response = service.update(new Servico(), 1L);

        assertNotNull(response);
    }

    @Test
    void updateWithNoData() {
        when(repository.findById(any())).thenThrow(new DataNotFoundException());
        
        assertThrows(DataNotFoundException.class, () -> service.update(new Servico(), 1L));
    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(any());

        assertDoesNotThrow(() -> service.delete(1L));
    }

    @Test
    void search() {
        when(repository.findAll(any(ServicoSpecification.class)))
        .thenReturn(List.of(new Servico()));

        var specs = mock(ServicoSpecification.class);

        assertNotNull(service.search(specs));
    }
}
