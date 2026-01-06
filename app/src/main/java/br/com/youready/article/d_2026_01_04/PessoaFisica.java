package br.com.youready.article.d_2026_01_04;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @CPF
    private String cpf;

    public static PessoaFisica comEmail(String email) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.email = email;

        return pessoaFisica;
    }
}
