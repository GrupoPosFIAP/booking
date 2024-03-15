package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.opcionais.Item;
import br.com.fiap.booking.dto.ItemDto;

public class ItemMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private ItemMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new ItemMapper(MODEL_MAPPER);
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
        var newEntity = new Item();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Item getEntity() {
        return Item
            .builder()
            .descricao("descricao")
            .nome("nome")
            .localidade(null)
            .quantidade(1)
            .value(BigDecimal.valueOf(500.00))
            .id(1L)
            .build();
    }

    private ItemDto getDto() {
        return ItemDto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .localidade(null)
            .quantidade(1)
            .value(BigDecimal.valueOf(500.00))
            .id(1L)
            .build();
    }
}
