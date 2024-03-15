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

import br.com.fiap.booking.controller.specifications.ReservaSpecification;
import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.exception.DataNotFoundException;
import br.com.fiap.booking.mapper.ReservaMapper;
import br.com.fiap.booking.repository.ReservaRepository;

@ExtendWith(MockitoExtension.class)
public class ReservaCrudServiceTest {

    @InjectMocks
    private ReservaCrudService service;

    @Mock
    private ReservaRepository repository;

    private ReservaMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new ReservaMapper(new ModelMapper());
        service = new ReservaCrudService(repository, mapper);
    }

    @Test
    void create() {
        when(repository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        var servico = new Reserva();

        var response = service.create(servico);

        assertNotNull(response);
    }

    @Test
    void read() {
        when(repository.findById(any())).thenReturn(Optional.of(new Reserva()));

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

        when(repository.findById(any())).thenReturn(Optional.of(new Reserva()));

        var response = service.update(new Reserva(), 1L);

        assertNotNull(response);
    }

    @Test
    void updateWithNoData() {
        when(repository.findById(any())).thenThrow(new DataNotFoundException());
        
        assertThrows(DataNotFoundException.class, () -> service.update(new Reserva(), 1L));
    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(any());

        assertDoesNotThrow(() -> service.delete(1L));
    }

    @Test
    void search() {
        when(repository.findAll(any(ReservaSpecification.class)))
        .thenReturn(List.of(new Reserva()));

        var specs = mock(ReservaSpecification.class);

        assertNotNull(service.search(specs));
    }
}
