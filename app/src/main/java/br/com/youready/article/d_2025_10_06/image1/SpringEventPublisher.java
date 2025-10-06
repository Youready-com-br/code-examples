package br.com.youready.article.d_2025_10_06.image1;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("spring")
@AllArgsConstructor
public class SpringEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(String topic, DomainEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
