package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.opcionais.Servico;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Spec(path = "nome", spec = LikeIgnoreCase.class)
public interface ServicoSpecification extends Specification<Servico> {

}
