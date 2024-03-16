package br.com.fiap.booking.service;

import br.com.fiap.booking.domain.reservas.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;


    public void sendMail(Reserva reserva) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("emersonpradoo61@gmail.com");
        mailMessage.setTo("lucasmacedo9@hotmail.com", "kesaraujo@gmail.com","emersonpradoo@hotmail.com", "fabio__tche@hotmail.com");
        mailMessage.setSubject("Reserva efetuada com sucesso!");
        mailMessage.setText("Sua reserva de número "+ reserva.getId()+ " foi realizada com sucesso!");
        mailSender.send(mailMessage);
    }
}
