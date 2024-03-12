package br.com.fiap.booking.repository;

import br.com.fiap.booking.domain.Localidade;
import br.com.fiap.booking.domain.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
}
