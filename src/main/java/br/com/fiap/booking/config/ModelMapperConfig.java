package br.com.fiap.booking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.booking.domain.BaseEntity;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper
            .typeMap(BaseEntity.class, BaseEntity.class)
            .addMappings(mp -> {
                mp.skip(BaseEntity::setId);
            });
        return mapper;
    }
}
