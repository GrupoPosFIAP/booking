package br.com.fiap.booking.controller;

import br.com.fiap.booking.repository.custom.ReservaCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/reserva")
@RestController
public class ReservaController {

    @Autowired
    private ReservaCustomRepository reservaCustomRepository;

    @GetMapping("/{id}")
    public Object consultarReservas(@PathVariable Long id) {
        List<Map<String, Object>> object = this.reservaCustomRepository.consultarQuartosLivres(id);
        object.stream().forEach(map -> {
            if(map.get("quantidade_reservas") == null) {
                map.remove("quantidade_reservas");
                map.put("quantidade_reservas", 0);
            }
            map.put("reservas_restantes", Long.parseLong(map.get("quantidade_quartos").toString()) - Long.parseLong(map.get("quantidade_reservas").toString()));
        });
        return object;
    }

}
