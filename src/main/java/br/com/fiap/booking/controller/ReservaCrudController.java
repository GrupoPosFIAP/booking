package br.com.fiap.booking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.booking.controller.specifications.ReservaSpecification;
import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.dto.ReservaDto;
import br.com.fiap.booking.mapper.ReservaMapper;
import br.com.fiap.booking.service.ReservaCrudService;

@RestController
@RequestMapping("/reservas")
public class ReservaCrudController
        extends BaseCrudController<Reserva, ReservaDto> {

    public ReservaCrudController(
            ReservaCrudService service,
            ReservaMapper mapper) {
        super(service, mapper);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ReservaDto> cadastrar(@RequestBody ReservaDto dto) {
        var response = ((ReservaCrudService) getCrudService()).cadastrarReserva(dto);

        var responseDto = ((ReservaMapper) getMapper()).toDto(response);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<ReservaDto> create(@RequestBody ReservaDto dto) {
        return super.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> update(@RequestBody ReservaDto dto, @PathVariable("id") Long id) {
        return super.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ReservaDto>> search(ReservaSpecification specs) {
        return super.search(specs);
    }
}
