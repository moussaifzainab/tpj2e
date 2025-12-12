package com.example.activemq.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.example.activemq.models.Company;

@Component
public class MyJmsPublisher {

    private static final Logger logger = LoggerFactory.getLogger(MyJmsPublisher.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jsa.activemq.topic}")
    String topic;

    public void send(Company company) {
        jmsTemplate.convertAndSend(topic, company);
        logger.info("Message : {} published to topic: {} successfully.",
                company.toString(), topic);
    }
}

