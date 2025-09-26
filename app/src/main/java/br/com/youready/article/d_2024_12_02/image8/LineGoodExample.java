package br.com.youready.article.d_2024_12_02.image8;

public class LineGoodExample {

    class Point {
        double x, y;

        double distancia(Point other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }
    }

    class Line {
        Point inicio;
        Point fim;

        double comprimento() {
            return inicio.distancia(fim);
        }
    }
}
