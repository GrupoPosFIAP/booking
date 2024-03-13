package br.com.fiap.booking.mapper;

import br.com.fiap.booking.domain.BaseEntity;

public interface BaseMapper<E extends BaseEntity, DTO> {

    E mapping(E source, E destination);

    E toEntity(DTO dto);

    DTO toDto(E entity);

}
