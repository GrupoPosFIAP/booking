package br.com.fiap.booking.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Localidade extends BaseEntity {
    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    @ElementCollection
    private List<String> amenidades;
}
