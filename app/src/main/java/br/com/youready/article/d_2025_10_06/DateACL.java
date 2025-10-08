package br.com.youready.article.d_2025_10_06;

// Anti-Corruption Layer (ACL) for Date API
interface DateACL {
    String now();

    String getInterval(String start, String end);

    String plusWeeks(String date, int weeks);

    String plusHours(String date, int hours);
}
