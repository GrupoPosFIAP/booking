package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.Usuario;
import br.com.fiap.booking.dto.UsuarioDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioMapper implements BaseMapper<Usuario, UsuarioDto> {

    private final ModelMapper mapper;

    @Override
    public Usuario mapping(Usuario source, Usuario destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        return mapper.map(dto, Usuario.class);
    }

    @Override
    public UsuarioDto toDto(Usuario entity) {
        return mapper.map(entity, UsuarioDto.class);
    }
}
