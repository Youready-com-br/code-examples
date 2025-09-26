package br.com.youready.article.d_2025_01_13.image2;

public class AnoBissexto {
    public static boolean ehAnoBissexto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
