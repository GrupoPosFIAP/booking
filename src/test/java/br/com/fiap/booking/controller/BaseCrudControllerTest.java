package br.com.fiap.booking.controller;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
public class BaseCrudControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    public String getJsonContent(String path) throws IOException {
        var file = new ClassPathResource(path).getFile();
        var bytes = Files.readAllBytes(file.toPath());
        return new String(bytes);
    }

    public <T> T jsonToClass(String path, Class<T> clazz) throws IOException {
        var json = getJsonContent(path);
        return new ObjectMapper().readValue(json, clazz);
    }
}
