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

import br.com.fiap.booking.controller.specifications.LocalidadeSpecification;
import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.mapper.LocalidadeMapper;
import br.com.fiap.booking.repository.LocalidadeRepository;
import br.com.fiap.booking.service.LocalidadeCrudService;

@ContextConfiguration(classes = {
        LocalidadeCrudController.class,
        LocalidadeCrudService.class,
        LocalidadeMapper.class,
        ModelMapper.class
})
public class LocalidadeCrudControllerTest extends BaseCrudControllerTest {

    @MockBean
    private LocalidadeRepository repository;

    private String request;

    @BeforeEach
    void initTests() throws IOException {
        request = getJsonContent("localidade_request.json");
    }

    @Test
    void testCreate() throws Exception {

        when(repository.save(any()))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        mockMvc
                .perform(
                        post("/localidades")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void testRead() throws Exception {

        doReturn(Optional.of(new Localidade()))
                .when(repository).findById(any());

        mockMvc
                .perform(
                        get("/localidades/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testUpdate() throws Exception {

        doReturn(Optional.of(new Localidade()))
                .when(repository).findById(any());

        doReturn(new Localidade())
                .when(repository).save(any());

        mockMvc
                .perform(
                        put("/localidades/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testDelete() throws Exception {
        doReturn(Optional.of(new Localidade()))
                .when(repository).findById(any());

        doNothing()
                .when(repository).deleteById(any());
        mockMvc
                .perform(
                        delete("/localidades/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSearch() throws Exception {

        var localidades = List.of(
                Localidade.builder().nome("São Paulo Hotel").build(),
                Localidade.builder().nome("São Paulo Plaza Hotel").build(),
                Localidade.builder().nome("São Petersburgo Hotel Inn").build());

        doReturn(localidades)
                .when(repository).findAll(any(LocalidadeSpecification.class));

        mockMvc
                .perform(
                        get("/localidades?cidade=São")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}
