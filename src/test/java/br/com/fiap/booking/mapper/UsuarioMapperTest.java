package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.Usuario;
import br.com.fiap.booking.dto.UsuarioDto;

public class UsuarioMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private UsuarioMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new UsuarioMapper(MODEL_MAPPER);
    }

    @Test
    void toDtoTest() {
        var entity = getEntity();
        var dto = mapper.toDto(entity);

        assertEquals(entity.getDescricao(), dto.getDescricao());
    }

    @Test
    void toEntityTest() {
        var dto = getDto();
        var entity = mapper.toEntity(dto);

        assertEquals(dto.getDescricao(), entity.getDescricao());
    }

    @Test
    void mappingTest() {
        var newEntity = new Usuario();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Usuario getEntity() {
        return Usuario
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .cpf("00000000000")
            .dataNascimento(LocalDate.MIN)
            .email("email@test.com")
            .build();
    }

    private UsuarioDto getDto() {
        return UsuarioDto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .cpf("00000000000")
            .dataNascimento(LocalDate.MIN)
            .email("email@test.com")
            .build();
    }
}
