package br.com.youready.article.d_2025_10_06;

import org.joda.time.Interval;

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
        return new org.joda.time.LocalDateTime(date).plusWeeks(weeks).toString("yyyy-MM-dd'T'HH:mm");
    }

    @Override
    public String plusHours(String date, int hours) {
        return new org.joda.time.LocalDateTime(date).plusHours(hours).toString("yyyy-MM-dd'T'HH:mm");
    }
}
