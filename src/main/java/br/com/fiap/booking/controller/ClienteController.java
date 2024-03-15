package br.com.fiap.booking.controller;

import br.com.fiap.booking.domain.Cliente;
import br.com.fiap.booking.dto.ClienteDTO;
import br.com.fiap.booking.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public Cliente cadastrarCliente(@RequestBody ClienteDTO dto) {
        return this.clienteService.save(dto);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> consultarCliente(@PathVariable Long id) {
        return this.clienteService.findById(id);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return this.clienteService.findAll();
    }

    @PutMapping("/{id}")
    public Optional<Cliente> atualizarCliente(@PathVariable("id") Long id, @RequestBody ClienteDTO dto) {
        return this.clienteService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable("id") Long id) {
        this.clienteService.delete(id);
    }
}
