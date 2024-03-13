package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.Quarto;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Or({
    @Spec(path = "totalPessoas", spec = GreaterThanOrEqual.class),
    @Spec(path = "quantidadeCamas", spec = GreaterThanOrEqual.class),
    @Spec(path = "value", spec = LessThanOrEqual.class)
})
public interface QuartoSpecification extends Specification<Quarto> {

}
