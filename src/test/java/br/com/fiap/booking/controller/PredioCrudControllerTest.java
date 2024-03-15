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

import br.com.fiap.booking.controller.specifications.PredioSpecification;
import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.mapper.PredioMapper;
import br.com.fiap.booking.repository.PredioRepository;
import br.com.fiap.booking.service.PredioCrudService;

@ContextConfiguration(classes = {
        PredioCrudController.class,
        PredioCrudService.class,
        PredioMapper.class,
        ModelMapper.class
})
public class PredioCrudControllerTest extends BaseCrudControllerTest {

    @MockBean
    private PredioRepository repository;

    private String request;

    @BeforeEach
    void initTests() throws IOException {
        request = getJsonContent("predio_request.json");
    }

    @Test
    void testCreate() throws Exception {

        when(repository.save(any()))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        mockMvc
                .perform(
                        post("/predios")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void testRead() throws Exception {

        doReturn(Optional.of(new Predio()))
                .when(repository).findById(any());

        mockMvc
                .perform(
                        get("/predios/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testUpdate() throws Exception {

        doReturn(Optional.of(new Predio()))
                .when(repository).findById(any());

        doReturn(new Predio())
                .when(repository).save(any());

        mockMvc
                .perform(
                        put("/predios/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testDelete() throws Exception {
        doReturn(Optional.of(new Predio()))
                .when(repository).findById(any());

        doNothing()
                .when(repository).deleteById(any());
        mockMvc
                .perform(
                        delete("/predios/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSearch() throws Exception {

        var predios = List.of(
                Predio.builder().nome("Predio 1 ").build(),
                Predio.builder().nome("Predio 2").build(),
                Predio.builder().nome("Predio 3").build());

        doReturn(predios)
                .when(repository).findAll(any(PredioSpecification.class));

        mockMvc
                .perform(
                        get("/predios?nome=Predio")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}
