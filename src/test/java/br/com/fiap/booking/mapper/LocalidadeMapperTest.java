package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.dto.LocalidadeDto;

public class LocalidadeMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private LocalidadeMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new LocalidadeMapper(MODEL_MAPPER);
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
        var newEntity = new Localidade();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Localidade getEntity() {
        return Localidade
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .amenidades(List.of("one", "two", "three"))
            .cep("00000000")
            .cidade("São Paulo")
            .estado("SP")
            .pais("Brasil")
            .rua("Rua rua")
            .build();
    }

    private LocalidadeDto getDto() {
        return LocalidadeDto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .amenidades(List.of("one", "two", "three"))
            .cep("00000000")
            .cidade("São Paulo")
            .estado("SP")
            .pais("Brasil")
            .rua("Rua rua")
            .build();
    }
}
