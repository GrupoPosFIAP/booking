package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.dto.QuartoDto;

public class QuartoMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private QuartoMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new QuartoMapper(MODEL_MAPPER);
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
        var newEntity = new Quarto();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Quarto getEntity() {
        return Quarto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .moveis(List.of("movel"))
            .numero(500L)
            .predio(null)
            .quantidadeBanheiros(1)
            .quantidadeCamas(1)
            .quantidadeQuartos(10)
            .tipo("STANDARD")
            .totalPessoas(4)
            .value(BigDecimal.valueOf(500L))
            .build();
    }

    private QuartoDto getDto() {
        return QuartoDto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .moveis(List.of("movel"))
            .numero(500L)
            .predio(null)
            .quantidadeBanheiros(1)
            .quantidadeCamas(1)
            .quantidadeQuartos(10)
            .tipo("STANDARD")
            .totalPessoas(4)
            .value(BigDecimal.valueOf(500L))
            .build();
    }
}
