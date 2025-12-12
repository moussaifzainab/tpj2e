package com.myJMS.messagingjms.repository;

import com.myJMS.messagingjms.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("---- repository.Received from sender: <" + email + ">");
    }
}
