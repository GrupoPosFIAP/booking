package br.com.fiap.booking.controller.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.booking.domain.Reserva;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.EqualDay;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Join(path = "quarto", alias = "q")
@And({
        @Spec(path = "q.numero", spec = Equal.class),
        @Spec(path = "inicioReserva", params = "inicio", spec = EqualDay.class),
        @Spec(path = "fimReserva", params = "fim", spec = EqualDay.class)
})
public interface ReservaSpecification extends Specification<Reserva> {

}
