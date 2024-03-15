package br.com.fiap.booking.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.fiap.booking.domain.opcionais.Item;
import br.com.fiap.booking.domain.opcionais.Servico;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Reserva extends BaseEntity {

    @ManyToOne
    private Quarto quarto;
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
    private LocalDateTime dataInicial;
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
    private LocalDateTime dataFinal;
    @OneToMany
    private List<Item> itens;
    @OneToMany
    private List<Servico> servicos;
    private Usuario cliente;
    private Integer totalPessoas;
}
