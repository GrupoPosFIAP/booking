package br.com.fiap.booking.controller;

import br.com.fiap.booking.service.ReservaCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ReservaControllerTest {

    @InjectMocks
    ReservaController reservaController;

    @Mock
    ReservaCrudService reservaCrudService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }




    @Test
    public void shouldCallDeletarReservaWhenDeletarReservaIsCalled() {
        Long id = 1L;

        doNothing().when(reservaCrudService).deletarReserva(id);

        reservaController.deletarReserva(id);

        verify(reservaCrudService, times(1)).deletarReserva(id);
    }
}