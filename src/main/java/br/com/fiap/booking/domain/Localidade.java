package br.com.fiap.booking.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    @ElementCollection
    private List<String> amenidades;
}
