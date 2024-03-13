package br.com.fiap.booking.service;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.opcionais.Item;
import br.com.fiap.booking.mapper.ItemMapper;
import br.com.fiap.booking.repository.ItemRepository;

@Service
public class ItemCrudService extends BaseCrudService<Item> {

    public ItemCrudService(ItemRepository repository, ItemMapper mapper) {
        super(repository, mapper);
    }

}
