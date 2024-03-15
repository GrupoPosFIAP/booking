package br.com.fiap.booking.dto;

import br.com.fiap.booking.domain.Cliente;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class ClienteDTO {

    @NotBlank(message = "Informe o nome")
    private String nome;

    @NotBlank(message = "Informe o país de origem")
    private String paisOrigem;

    @NotBlank(message = "O CPF não pode estar em branco")
    @CPF(message = "CPF inválido")
    private String cpf;
    private String passaporte;
    private LocalDate dataDeNascimento;
    private String enderecoPaisOrigem;
    private String telefone;

    @Email(message = "O email deve estar em um formato válido")
    private String email;

    public Cliente toEntity() {

        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setPaisOrigem(this.paisOrigem);
        cliente.setCpf(this.cpf);
        cliente.setPassaporte(this.passaporte);
        cliente.setDataDeNascimento(this.dataDeNascimento);
        cliente.setEnderecoPaisOrigem(this.enderecoPaisOrigem);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);
        return cliente;
    }
}
