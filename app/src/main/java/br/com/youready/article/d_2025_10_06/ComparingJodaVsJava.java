package br.com.youready.article.d_2025_10_06;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class ComparingJodaVsJava {

    public static void main(String[] args) {
        // Joda-Time tem Fluent API
        LocalDate date = LocalDate.of(2014, 12, 25); // Somente ano, mes dia
        LocalTime time = LocalTime.of(14, 30); // Somente hora, minuto
        LocalDateTime dt = LocalDateTime.now(); // Data e hora atuais

        // Java pré-8
        Date oldDate = new Date(); // Tem todos os componentes
    }
}

