package br.com.youready.article.d_2025_05_01.image4;

public class DispositivoInteligenteRefactoredExample {

    public interface DispositivoBasico {
        void ligar();

        void desligar();
    }

    public interface DispositivoInteligente extends DispositivoBasico {
        void reproduzirMusica();

        void ajustarVolume();

        void exibirNotificacoes();

        void controlarIluminacao();
    }

    public static class AltoFalanteInteligente implements DispositivoInteligente {
        public void ligar() {}

        public void desligar() {}

        public void reproduzirMusica() {}

        public void ajustarVolume() {}

        public void exibirNotificacoes() {}

        public void controlarIluminacao() {}
    }
}
