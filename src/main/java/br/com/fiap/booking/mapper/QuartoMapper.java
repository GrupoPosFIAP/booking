package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.dto.QuartoDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QuartoMapper implements BaseMapper<Quarto, QuartoDto> {

    private final ModelMapper mapper;

    @Override
    public Quarto mapping(Quarto source, Quarto destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Quarto toEntity(QuartoDto dto) {
        return mapper.map(dto, Quarto.class);
    }

    @Override
    public QuartoDto toDto(Quarto entity) {
        return mapper.map(entity, QuartoDto.class);
    }

}
