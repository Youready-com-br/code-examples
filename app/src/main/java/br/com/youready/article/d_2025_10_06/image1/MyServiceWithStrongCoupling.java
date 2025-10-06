package br.com.youready.article.d_2025_10_06.image1;

import org.springframework.stereotype.Service;

@Service
public class MyServiceWithStrongCoupling {

    private final KafkaEventPublisher eventPublisher;

    public MyServiceWithStrongCoupling() {
        this.eventPublisher = new KafkaEventPublisher(null); // PROBLEMA: Acoplamento forte
    }

    public void doSomething() {
        // ... some business logic
        eventPublisher.publish("some-topic", new MyDomainEvent());
    }

    private static class MyDomainEvent extends DomainEvent {}
}
