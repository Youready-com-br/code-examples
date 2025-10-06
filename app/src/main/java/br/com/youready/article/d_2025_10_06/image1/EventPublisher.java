package br.com.youready.article.d_2025_10_06.image1;

public interface EventPublisher {

    void publish(String topic, DomainEvent event);
}
