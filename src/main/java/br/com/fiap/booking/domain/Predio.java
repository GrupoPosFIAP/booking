package br.com.fiap.booking.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Predio extends BaseEntity {

    @ManyToOne
    private Localidade localidade;

}
