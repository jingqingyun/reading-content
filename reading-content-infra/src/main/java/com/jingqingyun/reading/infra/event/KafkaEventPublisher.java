package com.jingqingyun.reading.infra.event;

import ddd.Event;
import ddd.EventPublisher;
import ddd.EventPublisherDelegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * EventBus
 *
 * @author jingqingyun
 * @date 2020/10/13
 */
@Slf4j
@Component
public class KafkaEventPublisher implements EventPublisher {

    public static final String TOPIC = "com.jingqingyun.reading.content";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostConstruct
    public void delegate() {
        EventPublisherDelegate.instance().delegate(this);
        log.info("KafkaEventPublisher delegated");
    }

    @Override
    public void publish(Event event) {
        kafkaTemplate.send(TOPIC, event);
    }

}
