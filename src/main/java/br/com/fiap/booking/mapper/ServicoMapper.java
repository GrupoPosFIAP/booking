package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.opcionais.Servico;
import br.com.fiap.booking.dto.ServicoDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ServicoMapper implements BaseMapper<Servico, ServicoDto> {

    private final ModelMapper mapper;

    @Override
    public Servico mapping(Servico source, Servico destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Servico toEntity(ServicoDto dto) {
        return mapper.map(dto, Servico.class);
    }

    @Override
    public ServicoDto toDto(Servico entity) {
        return mapper.map(entity, ServicoDto.class);
    }
}
