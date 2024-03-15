package br.com.fiap.booking.domain;

import java.util.List;

import jakarta.persistence.Entity;
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
public class Localidade extends BaseEntity {
    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private List<String> amenidades;
}
