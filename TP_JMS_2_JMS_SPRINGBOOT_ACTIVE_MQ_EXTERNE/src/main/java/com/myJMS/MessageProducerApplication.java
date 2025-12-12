package com.myJMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import com.myJMS.model.Product;

@SpringBootApplication
@EnableJms
public class MessageProducerApplication {

    private static final String MESSAGE_QUEUE = "message_queue";

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(MessageProducerApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setProductId(i);
            product.setName("Laptop");
            product.setQuantity(10 + i);

            System.out.println("*** MessageProducerApplication : Sending a product " + i);
            jmsTemplate.convertAndSend(MESSAGE_QUEUE, product);
        }
    }
}
