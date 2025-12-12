package com.example.activemq.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.activemq.models.Company;

@Component
public class JmsSubcriber {

    private static final Logger logger =
            LoggerFactory.getLogger(JmsSubcriber.class);

    @JmsListener(destination = "${jsa.activemq.topic}")
    public void receive(Company msg) {
        logger.info("*** JmsSubcriber Recieved Message: {}", msg.toString());
    }
}

