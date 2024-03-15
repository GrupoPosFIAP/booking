package br.com.fiap.booking.service;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.Usuario;
import br.com.fiap.booking.mapper.UsuarioMapper;
import br.com.fiap.booking.repository.UsuarioRepository;

@Service
public class UsuarioCrudService extends BaseCrudService<Usuario> {

    public UsuarioCrudService(UsuarioRepository repository, UsuarioMapper mapper) {
        super(repository, mapper);
    }

}
