package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.Quarto;
import br.com.fiap.booking.domain.dto.QuartoReservaDto;
import br.com.fiap.booking.domain.dto.ReservaDto;
import br.com.fiap.booking.domain.reservas.Reserva;
import br.com.fiap.booking.repository.ItemRepository;
import br.com.fiap.booking.repository.QuartoRepository;
import br.com.fiap.booking.repository.ReservaRepository;
import br.com.fiap.booking.repository.ServicoRepository;
import br.com.fiap.booking.repository.custom.ReservaCustomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class ReservaCrudService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private ReservaCustomRepository reservaCustomRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public Reserva cadastrarReserva(ReservaDto reservaDto) {
        Quarto quarto = this.quartoRepository.findById(reservaDto.getIdQuarto())
                .orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado."));
        reservaDto.getIdItem().forEach(id -> {
            this.itemRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Item não encontrado."));
        });
        reservaDto.getIdServico().forEach(id -> {
            this.servicoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado."));
        });
        if (reservaDto.getDataInicial().isBefore(LocalDate.now()) || reservaDto.getDataFinal().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data de reserva não pode ser menor que a data atual.");
        }
        if (reservaDto.getDataFinal().isBefore(reservaDto.getDataInicial())) {
            throw new RuntimeException("Data final não pode ser menor que a data inicial.");
        }
        if (reservaDto.getTotalPessoas() > quarto.getTotalPessoas()) {
            throw new RuntimeException("Quantidade de pessoas maior que a capacidade do quarto.");
        }
        Reserva reserva = this.reservaRepository.save(reservaDto.toEntity(quarto, Collections.emptyList(), Collections.emptyList()));

        emailService.sendMail(reserva);

        return reserva;
    }

    public Object atualizarReserva(Long id, ReservaDto reservaDto) {
        Quarto quarto = this.quartoRepository.findById(reservaDto.getIdQuarto())
                .orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado."));
        Reserva reserva = this.reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada."));
        reserva.setQuarto(quarto);
        reserva.setDataInicial(reservaDto.getDataInicial());
        reserva.setDataFinal(reservaDto.getDataFinal());
        reserva.setTotalPessoas(reservaDto.getTotalPessoas());
        return this.reservaRepository.save(reserva);
    }

    public void deletarReserva(Long id) {
        this.reservaRepository.deleteById(id);
    }

    public List<QuartoReservaDto> consultarReservas(LocalDate dataInicial, LocalDate dataFinal, long totalPessoas) {
        List<QuartoReservaDto> quartosDisponiveis = this.reservaCustomRepository.consultarQuartosLivres(dataInicial, dataFinal, totalPessoas);
        if (quartosDisponiveis.isEmpty()) {
            throw new RuntimeException("Não há quartos disponíveis para a data informada.");
        }
        return quartosDisponiveis;
    }
}