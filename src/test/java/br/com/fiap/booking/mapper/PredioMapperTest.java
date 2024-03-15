package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.dto.PredioDto;

public class PredioMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private PredioMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new PredioMapper(MODEL_MAPPER);
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
        var newEntity = new Predio();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Predio getEntity() {
        return Predio
            .builder()
            .id(1L)
            .nome("nome")
            .descricao("descricao")
            .localidade(null)
            .build();
    }

    private PredioDto getDto() {
        return PredioDto
            .builder()
            .id(1L)
            .nome("nome")
            .descricao("descricao")
            .localidade(null)
            .build();
    }
}
