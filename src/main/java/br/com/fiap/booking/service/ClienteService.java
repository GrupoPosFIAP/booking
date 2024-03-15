package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Cliente;
import br.com.fiap.booking.dto.ClienteDTO;
import br.com.fiap.booking.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(ClienteDTO dto) {
        return clienteRepository.save(dto.toEntity());
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> update(Long id, ClienteDTO dto) {

        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {

            Cliente cliente = optionalCliente.get();

            cliente.setNome(dto.getNome());
            cliente.setPaisOrigem(dto.getPaisOrigem());
            cliente.setCpf(dto.getCpf());
            cliente.setPassaporte(dto.getPassaporte());
            cliente.setDataDeNascimento(dto.getDataDeNascimento());
            cliente.setEnderecoPaisOrigem(dto.getEnderecoPaisOrigem());
            cliente.setTelefone(dto.getTelefone());
            cliente.setEmail(dto.getEmail());

            clienteRepository.save(cliente);
        }

        return optionalCliente;
    }

    public void delete(Long id) {
        this.clienteRepository.delete(id);
    }
}
