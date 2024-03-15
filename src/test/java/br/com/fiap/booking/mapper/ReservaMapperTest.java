package br.com.fiap.booking.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.dto.ReservaDto;

public class ReservaMapperTest {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private ReservaMapper mapper;

    @BeforeEach
    void initTests() {
        mapper = new ReservaMapper(MODEL_MAPPER);
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
        var newEntity = new Reserva();
        var entity = getEntity();

        mapper.mapping(entity, newEntity);

        assertEquals(entity.getDescricao(), newEntity.getDescricao());
    }

    private Reserva getEntity() {
        return Reserva
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .fimReserva(LocalDateTime.now())
            .inicioReserva(LocalDateTime.now())
            .quarto(null)
            .build();
    }

    private ReservaDto getDto() {
        return ReservaDto
            .builder()
            .descricao("descricao")
            .nome("nome")
            .id(1L)
            .fimReserva(LocalDateTime.now())
            .inicioReserva(LocalDateTime.now())
            .quarto(null)
            .build();
    }
}
