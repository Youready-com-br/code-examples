package br.com.youready.article.d_2025_05_01.image1;

// Interface com as capacidades de um smartphone
interface SmartPhone {
    void tocaMusica();

    void tiraFoto();
}

class IPhone13 implements SmartPhone {
    @Override
    public void tocaMusica() {
        System.out.println("Tocando musica no iPhone 13");
    }

    @Override
    public void tiraFoto() {
        System.out.println("Tirando foto no iPhone 13");
    }
}

// Problema!
class CelularAntigo implements SmartPhone {
    @Override
    public void tocaMusica() {
        System.out.println("Tocando musica no celular antigo");
    }

    // Por usar a interface, a classe é obrigado a implementar
    // Mas é ruim pois causa efeitos colaterais:
    // - Ou criamos um método que lança uma excecao
    // - Ou criamos um método vazio
    // Ou seja, é um desperdicio e pode confundir o usuario deste objeto.
    @Override
    public void tiraFoto() {
        throw new UnsupportedOperationException("Celular antigo nao tira foto");
    }
}
