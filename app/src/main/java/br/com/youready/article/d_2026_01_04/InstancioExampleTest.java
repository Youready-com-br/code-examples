package br.com.youready.article.d_2026_01_04;

import org.instancio.Instancio;
import org.instancio.Model;
import org.instancio.Select;
import org.instancio.settings.Keys;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InstancioExampleTest {

    @Test
    void simpleObjectCreationExample() {
        // Por padrão, todos os campos são populados com dados aleatórios!
        PessoaFisica pessoaFisicaParaTeste =
                Instancio.create(PessoaFisica.class);

        assertThat(pessoaFisicaParaTeste).hasNoNullFieldsOrProperties();

        // Exemplo de saída: PessoaFisica(id=7317, name=GDFVO,
        // email=QJV, cpf=ACMOSMKKYB)
        System.out.println("pessoaFisicaParaTeste = " + pessoaFisicaParaTeste);
    }

    @Test
    void listCreationExample() {
        // Se não especificar o tamanho, ele cria uma lista de tamanho
        // aleatório entre 2 e 6 elementos
        List<PessoaFisica> listaDePF = Instancio.ofList(PessoaFisica.class)
                                                .size(3)
                                                .create();

        assertThat(listaDePF).hasSize(3)
                             .allSatisfy(pessoaFisica ->
                                     assertThat(pessoaFisica).hasNoNullFieldsOrProperties());

        // Exemplo de saída: [PessoaFisica(id=3373, name=LEUQQSPPR,
        // email=ZJHSDAVXVI, cpf=SYHZ),
        //      PessoaFisica(id=3724, name=ZZMIOSBKN, email=SXFXOF,
        //      cpf=CWEKYSUFQX),
        //      PessoaFisica(id=8790, name=MRMMR, email=PAAAD,
        //      cpf=RGOTNDXWF)]
        System.out.println("listaDePF = " + listaDePF);
    }

    @Test
    void populateOtherMandatoryFields() {
        String emailParaTeste = "teste@teste.com.br";
        // É possível popular o objeto após a definição de alguns dados
        PessoaFisica pessoaFisica = PessoaFisica.comEmail(emailParaTeste);

        Instancio.fill(pessoaFisica);

        assertThat(pessoaFisica)
                .hasNoNullFieldsOrProperties()
                .extracting(PessoaFisica::getEmail)
                .isEqualTo(emailParaTeste);

        // Exemplo de saída: PessoaFisica(id=6265, name=BMDJDFGYH,
        // email=teste@teste.com.br, cpf=EZPQVB)
        System.out.println("pessoaFisica = " + pessoaFisica);
    }

    @Test
    void useJakartaOrHibernateContraints() {
        // Instancio suporta:
        // jakarta.validation.constraints
        // javax.validation.constraints
        // org.hibernate.validator.constraints
        PessoaFisica pessoaFisica = Instancio.of(PessoaFisica.class)
                                             .withSetting(Keys.BEAN_VALIDATION_ENABLED, true)
                                             .withSetting(Keys.JPA_ENABLED, true)
                                             .create();

        assertThat(pessoaFisica).hasNoNullFieldsOrProperties();

        // Exemplo de saída: PessoaFisica(id=5966, name=MFARYO,
        // email=7hw1@wy.org, cpf=41474030777)
        // Observe que foi gerado um email e cpf válido aleatório.
        System.out.println("pessoaFisica = " + pessoaFisica);
    }

    @Test
    void useGenerator() {
        // É possível gerar os valores dos campos de acordo com a sua
        // necessidade
        PessoaFisica pessoaFisica = Instancio.of(PessoaFisica.class)
                                             .withSetting(Keys.BEAN_VALIDATION_ENABLED, true)
                                             .withSetting(Keys.JPA_ENABLED, true)
                                             .generate(
                                                     Select.field(PessoaFisica::getName),
                                                     generator -> generator.oneOf(
                                                             "Rafael",
                                                             "Issao",
                                                             "Thais"))
                                             .create();

        assertThat(pessoaFisica).hasNoNullFieldsOrProperties()
                                .extracting(PessoaFisica::getName)
                                .isIn("Rafael", "Issao", "Thais");

        // Exemplo de saída: PessoaFisica(id=4142, name=Rafael,
        // email=7@15z.com, cpf=38372761639)
        // O 'name' vai ser um dos três valores especificados
        System.out.println("pessoaFisica = " + pessoaFisica);
    }

    @Test
    void defineAModelAndUseInAnyTest() {
        // Defina o modelo e aproveite para utilizar em qualquer classe
        // de teste que precise do objeto
        Model<PessoaFisica> modeloParaPF = Instancio.of(PessoaFisica.class)
                                                    .withSetting(Keys.BEAN_VALIDATION_ENABLED, true)
                                                    .withSetting(Keys.JPA_ENABLED, true)
                                                    .generate(
                                                            Select.field(PessoaFisica::getName),
                                                            generator -> generator.oneOf(
                                                                    "Rafael",
                                                                    "Issao",
                                                                    "Thais"))
                                                    .toModel();

        PessoaFisica pessoaFisica = Instancio.create(modeloParaPF);

        assertThat(pessoaFisica).hasNoNullFieldsOrProperties()
                                .extracting(PessoaFisica::getName)
                                .isIn("Rafael", "Issao", "Thais");

        System.out.println("pessoaFisica = " + pessoaFisica);
    }
}
