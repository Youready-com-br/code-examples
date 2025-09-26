package br.com.youready.article.d_2025_05_01.image3;

public class DispositivoInteligenteExample {

    public interface DispositivoInteligente {
        void ligar();

        void desligar();

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
