package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Or({
    @Spec(path = "nome", spec = Like.class),
    @Spec(path = "cpf", spec = Equal.class),
    @Spec(path = "email", spec = Equal.class),
    @Spec(path = "dataNascimento", spec = Equal.class)
})
public interface UsuarioSpecification extends Specification<Usuario> {

}
