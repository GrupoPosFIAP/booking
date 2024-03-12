package br.com.fiap.booking.repository;

import br.com.fiap.booking.domain.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredioRepository extends JpaRepository<Predio, Long> {
}
