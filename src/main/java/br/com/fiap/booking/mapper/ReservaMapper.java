package br.com.fiap.booking.mapper;

import br.com.fiap.booking.domain.reservas.Reserva;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.dto.ReservaDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReservaMapper implements BaseMapper<Reserva, ReservaDto> {

    private final ModelMapper mapper;

    @Override
    public Reserva mapping(Reserva source, Reserva destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Reserva toEntity(ReservaDto dto) {
        return mapper.map(dto, Reserva.class);
    }

    @Override
    public ReservaDto toDto(Reserva entity) {
        return mapper.map(entity, ReservaDto.class);
    }
}
