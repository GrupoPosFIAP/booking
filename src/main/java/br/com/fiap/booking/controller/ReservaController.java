package br.com.fiap.booking.controller;

import br.com.fiap.booking.domain.dto.ReservaDto;
import br.com.fiap.booking.service.ReservaCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/reserva")
@RestController
public class ReservaController {

    @Autowired
    private ReservaCrudService reservaService;


    @GetMapping()
    public Object consultarReservas(@RequestParam(required = true) LocalDate dataInicial,
                                    @RequestParam(required = true) LocalDate dataFinal,
                                    @RequestParam(required = true) Long totalPessoas) {

        return this.reservaService.consultarReservas(dataInicial, dataFinal, totalPessoas);
    }

    @PostMapping
    public Object cadastrarReserva(@RequestBody ReservaDto reserva) {
        return this.reservaService.cadastrarReserva(reserva);
    }

    @PutMapping("/{id}")
    public Object atualizarReserva(@PathVariable Long id, @RequestBody ReservaDto reserva) {
        return this.reservaService.atualizarReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void deletarReserva(@PathVariable Long id) {
        this.reservaService.deletarReserva(id);
    }

}