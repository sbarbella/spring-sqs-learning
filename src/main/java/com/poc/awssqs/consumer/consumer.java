package com.poc.awssqs.consumer;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class consumer {

    private static final Logger logger = LoggerFactory.getLogger(consumer.class);

    @SqsListener(value = "standard-queue", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void receiveMessage(String stringJson) {
        logger.info("Message Received using SQS Listner " + stringJson);
    }
}
