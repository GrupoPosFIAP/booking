package br.com.fiap.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mail")
@RestController
public class EmailController {

    @Autowired
    JavaMailSender mailSender;

    @PostMapping
    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("emersonpradoo61@gmail.com");
        mailMessage.setTo("emersonpradoo@hotmail.com");
        mailMessage.setSubject("Spring test mail sender");
        mailMessage.setText("Sua reserva foi realizada com sucesso!");
        mailSender.send(mailMessage);
    }

}
