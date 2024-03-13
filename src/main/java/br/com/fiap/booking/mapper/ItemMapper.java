package br.com.fiap.booking.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.booking.domain.opcionais.Item;
import br.com.fiap.booking.dto.ItemDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ItemMapper implements BaseMapper<Item, ItemDto> {

    private final ModelMapper mapper;

    @Override
    public Item mapping(Item source, Item destination) {
        mapper.map(source, destination);
        return destination;
    }

    @Override
    public Item toEntity(ItemDto dto) {
        return mapper.map(dto, Item.class);
    }

    @Override
    public ItemDto toDto(Item entity) {
        return mapper.map(entity, ItemDto.class);
    }
}
