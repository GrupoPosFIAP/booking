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

import br.com.fiap.booking.controller.specifications.QuartoSpecification;
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.mapper.QuartoMapper;
import br.com.fiap.booking.repository.QuartoRepository;
import br.com.fiap.booking.service.QuartoCrudService;

@ContextConfiguration(classes = {
        QuartoCrudController.class,
        QuartoCrudService.class,
        QuartoMapper.class,
        ModelMapper.class
})
public class QuartoCrudControllerTest extends BaseCrudControllerTest {

    @MockBean
    private QuartoRepository repository;

    private String request;

    @BeforeEach
    void initTests() throws IOException {
        request = getJsonContent("quarto_request.json");
    }

    @Test
    void testCreate() throws Exception {

        when(repository.save(any()))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        mockMvc
                .perform(
                        post("/quartos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void testRead() throws Exception {

        doReturn(Optional.of(new Quarto()))
                .when(repository).findById(any());

        mockMvc
                .perform(
                        get("/quartos/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testUpdate() throws Exception {

        doReturn(Optional.of(new Quarto()))
                .when(repository).findById(any());

        doReturn(new Quarto())
                .when(repository).save(any());

        mockMvc
                .perform(
                        put("/quartos/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testDelete() throws Exception {
        doReturn(Optional.of(new Quarto()))
                .when(repository).findById(any());

        doNothing()
                .when(repository).deleteById(any());
        mockMvc
                .perform(
                        delete("/quartos/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSearch() throws Exception {

        var quartos = List.of(
                Quarto.builder().nome("Quarto 1 ").build(),
                Quarto.builder().nome("Quarto 2").build(),
                Quarto.builder().nome("Quarto 3").build());

        doReturn(quartos)
                .when(repository).findAll(any(QuartoSpecification.class));

        mockMvc
                .perform(
                        get("/quartos?nome=Quarto")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}
