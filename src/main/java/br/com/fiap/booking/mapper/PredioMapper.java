package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.dto.PredioDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PredioMapper implements BaseMapper<Predio, PredioDto> {

    private final ModelMapper mapper;

    @Override
    public Predio mapping(Predio source, Predio destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Predio toEntity(PredioDto dto) {
        return mapper.map(dto, Predio.class);
    }

    @Override
    public PredioDto toDto(Predio entity) {
        return mapper.map(entity, PredioDto.class);
    }
}
