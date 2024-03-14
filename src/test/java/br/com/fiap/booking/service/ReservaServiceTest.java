package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.dto.QuartoReservaDto;
import br.com.fiap.booking.domain.dto.ReservaDto;
import br.com.fiap.booking.domain.reservas.Reserva;
import br.com.fiap.booking.repository.QuartoRepository;
import br.com.fiap.booking.repository.ReservaRepository;
import br.com.fiap.booking.repository.custom.ReservaCustomRepository;
import br.com.fiap.booking.service.ReservaService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservaServiceTest {

    @InjectMocks
    private ReservaService reservaService;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private QuartoRepository quartoRepository;

    @Mock
    private ReservaCustomRepository reservaCustomRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldThrowExceptionWhenQuartoNotFound() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setIdQuarto(1L);
        when(quartoRepository.findById(reservaDto.getIdQuarto())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldThrowExceptionWhenDataInicialBeforeNow() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setIdQuarto(1L);
        reservaDto.setDataInicial(LocalDate.now().minusDays(1));
        when(quartoRepository.findById(reservaDto.getIdQuarto())).thenReturn(Optional.of(new Quarto()));

        assertThrows(RuntimeException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldThrowExceptionWhenDataFinalBeforeDataInicial() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setIdQuarto(1L);
        reservaDto.setDataInicial(LocalDate.now().plusDays(1));
        reservaDto.setDataFinal(LocalDate.now());
        when(quartoRepository.findById(reservaDto.getIdQuarto())).thenReturn(Optional.of(new Quarto()));

        assertThrows(RuntimeException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldThrowExceptionWhenTotalPessoasGreaterThanQuartoCapacity() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setIdQuarto(1L);
        reservaDto.setDataInicial(LocalDate.now());
        reservaDto.setDataFinal(LocalDate.now().plusDays(1));
        reservaDto.setTotalPessoas(5L);
        Quarto quarto = new Quarto();
        quarto.setTotalPessoas(4);
        when(quartoRepository.findById(reservaDto.getIdQuarto())).thenReturn(Optional.of(quarto));

        assertThrows(RuntimeException.class, () -> reservaService.cadastrarReserva(reservaDto));
    }

    @Test
    public void shouldSaveReservaWhenAllConditionsMet() {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setIdQuarto(1L);
        reservaDto.setDataInicial(LocalDate.now());
        reservaDto.setDataFinal(LocalDate.now().plusDays(1));
        reservaDto.setTotalPessoas(2L);
        Quarto quarto = new Quarto();
        quarto.setTotalPessoas(4);
        when(quartoRepository.findById(reservaDto.getIdQuarto())).thenReturn(Optional.of(quarto));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(new Reserva());

        Reserva reserva = reservaService.cadastrarReserva(reservaDto);

        assertNotNull(reserva);
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }
}