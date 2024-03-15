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

import br.com.fiap.booking.controller.specifications.ItemSpecification;
import br.com.fiap.booking.domain.opcionais.Item;
import br.com.fiap.booking.mapper.ItemMapper;
import br.com.fiap.booking.repository.ItemRepository;
import br.com.fiap.booking.service.ItemCrudService;

@ContextConfiguration(classes = {
        ItemCrudController.class,
        ItemCrudService.class,
        ItemMapper.class,
        ModelMapper.class
})
public class ItemCrudControllerTest extends BaseCrudControllerTest {

    @MockBean
    private ItemRepository repository;

    private String request;

    @BeforeEach
    void initTests() throws IOException {
        request = getJsonContent("item_request.json");
    }

    @Test
    void testCreate() throws Exception {

        when(repository.save(any()))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        mockMvc
                .perform(
                        post("/itens")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void testRead() throws Exception {

        doReturn(Optional.of(new Item()))
                .when(repository).findById(any());

        mockMvc
                .perform(
                        get("/itens/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testUpdate() throws Exception {

        doReturn(Optional.of(new Item()))
                .when(repository).findById(any());

        doReturn(new Item())
                .when(repository).save(any());

        mockMvc
                .perform(
                        put("/itens/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testDelete() throws Exception {
        doReturn(Optional.of(new Item()))
                .when(repository).findById(any());

        doNothing()
                .when(repository).deleteById(any());
        mockMvc
                .perform(
                        delete("/itens/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSearch() throws Exception {

        var itens = List.of(
                Item.builder().nome("Item 1 ").build(),
                Item.builder().nome("Item 2").build(),
                Item.builder().nome("Item 3").build());

        doReturn(itens)
                .when(repository).findAll(any(ItemSpecification.class));

        mockMvc
                .perform(
                        get("/itens?nome=Item")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }
}
