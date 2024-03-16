package br.com.fiap.booking.domain.reservas;

import br.com.fiap.booking.domain.BaseEntity;
import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.opcionais.Itens;
import br.com.fiap.booking.domain.opcionais.Servicos;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Reserva extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Quarto quarto;
    @OneToMany
    private List<Itens> itens;
    @OneToMany
    private List<Servicos> servicos;
    private Long idCliente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;
    private Long totalPessoas;

    public Reserva(Quarto quarto, List<Itens> itens, List<Servicos> servicos, Long idCliente, LocalDate dataInicial, LocalDate dataFinal, Long totalPessoas) {
        this.quarto = quarto;
        this.itens = itens;
        this.servicos = servicos;
        this.idCliente = idCliente;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.totalPessoas = totalPessoas;
    }

    public Reserva() {

    }
}
