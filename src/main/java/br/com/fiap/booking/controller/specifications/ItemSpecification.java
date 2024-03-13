package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.opcionais.Item;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Spec(path = "nome", spec = Like.class)
public interface ItemSpecification extends Specification<Item> {

}
