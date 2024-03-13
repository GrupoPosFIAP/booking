package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.opcionais.Servico;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
        @Spec(path = "nome", spec = Like.class)
})
public interface ServicoSpecification extends Specification<Servico> {

}
