package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.dto.LocalidadeDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LocalidadeMapper implements BaseMapper<Localidade, LocalidadeDto> {

    private final ModelMapper mapper;

    @Override
    public Localidade mapping(Localidade source, Localidade destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Localidade toEntity(LocalidadeDto dto) {
        return mapper.map(dto, Localidade.class);
    }

    @Override
    public LocalidadeDto toDto(Localidade entity) {
        return mapper.map(entity, LocalidadeDto.class);
    }
}
