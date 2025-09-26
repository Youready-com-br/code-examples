package br.com.youready.article.d_2024_12_02.image1;

public class PessoaExample {

    // Helper methods to simulate external interactions
    private static void imprimeNoArquivo(String texto) {
        System.out.println("Imprimindo no arquivo: " + texto);
    }

    private static void imprimeNoTerminal(String texto) {
        System.out.println("Imprimindo no terminal: " + texto);
    }

    private static void enviaViaRest(String texto) {
        System.out.println("Enviando via REST: " + texto);
    }

    public static void main(String[] args) {
        // Assuming Pessoa class exists with nome() and sobrenome() methods
        // For demonstration, let's create a simple anonymous class or mock
        class Pessoa {
            String nome;
            String sobrenome;

            Pessoa(String nome, String sobrenome) {
                this.nome = nome;
                this.sobrenome = sobrenome;
            }

            String nome() {
                return nome;
            }

            String sobrenome() {
                return sobrenome;
            }

            // Static factory method as seen in the OCR output
            static Pessoa comNome(String nome, String sobrenome) {
                return new Pessoa(nome, sobrenome);
            }
        }

        Pessoa pessoa = Pessoa.comNome("Rafael", "Issao");

        imprimeNoArquivo(pessoa.nome() + " " + pessoa.sobrenome());
        imprimeNoTerminal(pessoa.nome() + " " + pessoa.sobrenome());
        enviaViaRest(pessoa.nome() + " " + pessoa.sobrenome());
    }
}
