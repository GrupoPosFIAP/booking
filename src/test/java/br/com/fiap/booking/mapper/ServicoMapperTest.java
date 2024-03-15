package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.opcionais.Servico;
import br.com.fiap.booking.dto.ServicoDto;

public class ServicoMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private ServicoMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new ServicoMapper(MODEL_MAPPER);
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
        var newEntity = new Servico();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Servico getEntity() {
        return Servico
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .quantidade(0)
            .value(BigDecimal.valueOf(500L))
            .localidade(null)
            .build();
    }

    private ServicoDto getDto() {
        return ServicoDto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .quantidade(0)
            .value(BigDecimal.valueOf(500L))
            .localidade(null)
            .build();
    }
}
