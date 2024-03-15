package br.com.fiap.booking.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import br.com.fiap.booking.controller.specifications.ReservaSpecification;
import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.mapper.ReservaMapper;
import br.com.fiap.booking.repository.ReservaRepository;
import br.com.fiap.booking.service.ReservaCrudService;

@ContextConfiguration(classes = {
        ReservaCrudController.class,
        ReservaCrudService.class,
        ReservaMapper.class,
        ModelMapper.class
})
public class ReservaCrudControllerTest extends BaseCrudControllerTest {

    @MockBean
    private ReservaRepository repository;

    private String request;

    @BeforeEach
    void initTests() throws IOException {
        request = getJsonContent("reserva_request.json");
    }

    @Test
    void testCreate() throws Exception {

        when(repository.save(any()))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        mockMvc
                .perform(
                        post("/reservas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void testRead() throws Exception {

        doReturn(Optional.of(new Reserva()))
                .when(repository).findById(any());

        mockMvc
                .perform(
                        get("/reservas/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testUpdate() throws Exception {

        doReturn(Optional.of(new Reserva()))
                .when(repository).findById(any());

        doReturn(new Reserva())
                .when(repository).save(any());

        mockMvc
                .perform(
                        put("/reservas/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testDelete() throws Exception {
        doReturn(Optional.of(new Reserva()))
                .when(repository).findById(any());

        doNothing()
                .when(repository).deleteById(any());
        mockMvc
                .perform(
                        delete("/reservas/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSearch() throws Exception {

        var reservas = List.of(
                Reserva.builder().nome("Reserva 1 ").build(),
                Reserva.builder().nome("Reserva 2").build(),
                Reserva.builder().nome("Reserva 3").build());

        doReturn(reservas)
                .when(repository).findAll(any(ReservaSpecification.class));

        mockMvc
                .perform(
                        get("/reservas?nome=Reserva")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}
