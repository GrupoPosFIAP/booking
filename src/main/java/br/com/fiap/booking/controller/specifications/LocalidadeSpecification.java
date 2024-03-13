package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.Localidade;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Or({
    @Spec(path = "cidade", spec = Like.class),
    @Spec(path = "estado", spec = Like.class),
    @Spec(path = "pais", spec = Like.class)
})
public interface LocalidadeSpecification extends Specification<Localidade> {

}
