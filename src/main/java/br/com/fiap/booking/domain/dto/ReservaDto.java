package br.com.fiap.booking.domain.dto;


import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.opcionais.Itens;
import br.com.fiap.booking.domain.opcionais.Servicos;
import br.com.fiap.booking.domain.reservas.Reserva;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReservaDto {

    private Long idQuarto;
    private List<Long> idItem;
    private List<Long> idServico;
    private Long idCliente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;
    private Long totalPessoas;


    public Reserva toEntity(Quarto quarto, List<Itens> itens, List<Servicos> servicos) {
        return new Reserva(quarto, itens, servicos, this.idCliente, this.dataInicial, this.dataFinal, this.totalPessoas);
    }

}
