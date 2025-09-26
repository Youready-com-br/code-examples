package br.com.youready.article.d_2025_05_01.image2;

// Criamos uma interface especifica para cada capacidade
interface TemPlayer {
    void tocaMusica();
}

interface TemCamera {
    void tiraFoto();
}

// Mantemos a interface original
// para diminuir o custo da alteracao
interface SmartPhone extends TemPlayer, TemCamera {}

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

// Celular antigo agora so implementa a interface
// ‘TemPlayer'
class CelularAntigo implements TemPlayer {
    @Override
    public void tocaMusica() {
        System.out.println("Tocando musica no celular antigo");
    }
}
