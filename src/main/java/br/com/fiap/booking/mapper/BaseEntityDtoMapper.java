package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.dto.BaseDto;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BaseEntityDtoMapper implements BaseMapper<BaseEntity, BaseDto> {

    private final ModelMapper mapper;

    @PostConstruct
    public void createMappings() {
        mapper
            .typeMap(BaseEntity.class, BaseDto.class)
            .addMapping(BaseEntity::getId, BaseDto::setId)
            .includeBase(BaseEntity.class, BaseDto.class);
    }

    @Override
    public BaseEntity mapping(BaseEntity source, BaseEntity destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public BaseEntity toEntity(BaseDto dto) {
        return mapper.map(dto, BaseEntity.class);
    }

    @Override
    public BaseDto toDto(BaseEntity entity) {
        return mapper.map(entity, BaseDto.class);
    }

}
