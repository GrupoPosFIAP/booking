package br.com.fiap.booking.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
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
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.dto.QuartoDto;
import br.com.fiap.booking.dto.ReservaDto;
import br.com.fiap.booking.exception.DataNotFoundException;
import br.com.fiap.booking.mapper.ReservaMapper;
import br.com.fiap.booking.repository.QuartoRepository;
import br.com.fiap.booking.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ReservaCrudServiceTest {

    @InjectMocks
    private ReservaCrudService reservaService;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private QuartoRepository quartoRepository;

    @Mock
    private EmailService emailService;

    private ReservaMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new ReservaMapper(new ModelMapper());
        reservaService = new ReservaCrudService(reservaRepository, mapper, quartoRepository, emailService);
    }

    @Test
    void create() {
        when(reservaRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        var servico = new Reserva();

        var response = reservaService.create(servico);

        assertNotNull(response);
    }

    @Test
    void read() {
        when(reservaRepository.findById(any())).thenReturn(Optional.of(new Reserva()));

        var response = reservaService.read(1L);

        assertNotNull(response);

    }

    @Test
    void readWithoutData() {
        when(reservaRepository.findById(any())).thenThrow(new DataNotFoundException());

        assertThrows(DataNotFoundException.class, () -> reservaService.read(1L));
    }

    @Test
    void update() {

        when(reservaRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        when(reservaRepository.findById(any())).thenReturn(Optional.of(new Reserva()));

        var response = reservaService.update(new Reserva(), 1L);

        assertNotNull(response);
    }

    @Test
    void updateWithNoData() {
        when(reservaRepository.findById(any())).thenThrow(new DataNotFoundException());
        
        assertThrows(DataNotFoundException.class, () -> reservaService.update(new Reserva(), 1L));
    }

    @Test
    void delete() {
        doNothing().when(reservaRepository).deleteById(any());

        assertDoesNotThrow(() -> reservaService.delete(1L));
    }

    @Test
    void search() {
        when(reservaRepository.findAll(any(ReservaSpecification.class)))
        .thenReturn(List.of(new Reserva()));

        var specs = mock(ReservaSpecification.class);

        assertNotNull(reservaService.search(specs));
    }

    @Test
    public void shouldThrowExceptionWhenQuartoNotFound() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setQuarto(new QuartoDto());
        when(quartoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldThrowExceptionWhenDataInicialBeforeNow() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setQuarto(new QuartoDto());
        reservaDto.setDataInicial(LocalDateTime.now().minusDays(1));
        when(quartoRepository.findById(any())).thenReturn(Optional.of(new Quarto()));

        assertThrows(RuntimeException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldThrowExceptionWhenDataFinalBeforeDataInicial() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setQuarto(new QuartoDto());
        reservaDto.setDataInicial(LocalDateTime.now().plusDays(1));
        reservaDto.setDataFinal(LocalDateTime.now());
        when(quartoRepository.findById(any())).thenReturn(Optional.of(new Quarto()));

        assertThrows(RuntimeException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldThrowExceptionWhenTotalPessoasGreaterThanQuartoCapacity() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setQuarto(new QuartoDto());
        reservaDto.setDataInicial(LocalDateTime.now());
        reservaDto.setDataFinal(LocalDateTime.now().plusDays(1));
        reservaDto.setTotalPessoas(5);
        Quarto quarto = new Quarto();
        quarto.setTotalPessoas(4);
        when(quartoRepository.findById(any())).thenReturn(Optional.of(quarto));

        assertThrows(RuntimeException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldSaveReservaWhenAllConditionsMet() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setQuarto(new QuartoDto());
        reservaDto.setDataInicial(LocalDateTime.now().plusDays(1));
        reservaDto.setDataFinal(LocalDateTime.now().plusDays(2));
        reservaDto.setTotalPessoas(2);
        Quarto quarto = new Quarto();
        quarto.setTotalPessoas(4);
        when(quartoRepository.findById(any())).thenReturn(Optional.of(quarto));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(new Reserva());

        Reserva reserva = reservaService.cadastrarReserva(reservaDto);

        assertNotNull(reserva);
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }
}
