package br.com.fiap.booking.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.Reserva;
import br.com.fiap.booking.dto.ReservaDto;
import br.com.fiap.booking.mapper.ReservaMapper;
import br.com.fiap.booking.repository.QuartoRepository;
import br.com.fiap.booking.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaCrudService extends BaseCrudService<Reserva> {

    private QuartoRepository quartoRepository;

    private EmailService emailService;

    public ReservaCrudService(ReservaRepository repository, ReservaMapper mapper, QuartoRepository quartoRepository,
            EmailService emailService) {
        super(repository, mapper);
        this.quartoRepository = quartoRepository;
        this.emailService = emailService;
    }

    public Reserva cadastrarReserva(ReservaDto reservaDto) {
        Quarto quarto = this.quartoRepository.findById(reservaDto.getQuarto().getId())
                .orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado."));
        if (reservaDto.getDataInicial().isBefore(LocalDateTime.now())
                || reservaDto.getDataFinal().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Data de reserva não pode ser menor que a data atual.");
        }
        if (reservaDto.getDataFinal().isBefore(reservaDto.getDataInicial())) {
            throw new RuntimeException("Data final não pode ser menor que a data inicial.");
        }
        if (reservaDto.getTotalPessoas() > quarto.getTotalPessoas()) {
            throw new RuntimeException("Quantidade de pessoas maior que a capacidade do quarto.");
        }
        Reserva reserva = getRepository()
                .save(((ReservaMapper) getMapper()).toEntity(reservaDto));

        emailService.sendMail(reserva);

        return reserva;
    }

}
