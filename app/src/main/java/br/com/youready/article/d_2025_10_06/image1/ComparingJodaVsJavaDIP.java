package br.com.youready.article.d_2025_10_06.image1;

import java.time.Duration;
import java.time.LocalDateTime;
import org.joda.time.Interval;

// Anti-Corruption Layer (ACL) for Date API
interface DateACL {
    String now();

    String getInterval(String start, String end);

    String plusWeeks(String date, int weeks);

    String plusHours(String date, int hours);
}

class DateAPIWithJodaTime implements DateACL {
    @Override
    public String now() {
        return org.joda.time.LocalDateTime.now().toString();
    }

    @Override
    public String getInterval(String start, String end) {
        org.joda.time.LocalDateTime jodaStart = new org.joda.time.LocalDateTime(start);
        org.joda.time.LocalDateTime jodaEnd = new org.joda.time.LocalDateTime(end);
        return new Interval(jodaStart.toDateTime(), jodaEnd.toDateTime()).toString();
    }

    @Override
    public String plusWeeks(String date, int weeks) {
        return new org.joda.time.LocalDateTime(date).plusWeeks(weeks).toString();
    }

    @Override
    public String plusHours(String date, int hours) {
        return new org.joda.time.LocalDateTime(date).plusHours(hours).toString();
    }
}

class DateAPIWithJava8Native implements DateACL {
    @Override
    public String now() {
        return LocalDateTime.now().toString();
    }

    @Override
    public String getInterval(String start, String end) {
        return Duration.between(LocalDateTime.parse(start), LocalDateTime.parse(end))
                .toString();
    }

    @Override
    public String plusWeeks(String date, int weeks) {
        return LocalDateTime.parse(date).plusWeeks(weeks).toString();
    }

    @Override
    public String plusHours(String date, int hours) {
        return LocalDateTime.parse(date).plusHours(hours).toString();
    }
}

class BusinessRuleOneDIP {
    private final DateACL dateAPI;

    // Injeção de dependência via construtor
    public BusinessRuleOneDIP(DateACL dateAPI) {
        this.dateAPI = dateAPI;
    }

    public void doSomeWork() {
        // A regra de negócio não depende mais da implementação concreta da API de datas
        String now = dateAPI.now();
        String oneWeekLater = dateAPI.plusWeeks(now, 1);
        String interval = dateAPI.getInterval(now, oneWeekLater);

    }
}

class BusinessRuleTwoDIP {
    private final DateACL dateAPI;

    // Injeção de dependência via construtor
    public BusinessRuleTwoDIP(DateACL dateAPI) {
        this.dateAPI = dateAPI;
    }

    public void doMoreWork() {
        String now = dateAPI.now();
        String sixHoursLater = dateAPI.plusHours(now, 6);
        String interval = dateAPI.getInterval(now, sixHoursLater);
    }
}
