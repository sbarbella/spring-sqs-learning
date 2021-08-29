package com.poc.awssqs.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.awssqs.dto.student;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class producer {

    private static final Logger logger = LoggerFactory.getLogger(producer.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @PostMapping("/message")
    public student sendMessage(@RequestBody student student) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(student);
            queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(jsonString).build());
            logger.info("Message sent successfully  " + jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
