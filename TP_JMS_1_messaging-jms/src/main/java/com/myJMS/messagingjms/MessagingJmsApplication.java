package com.myJMS.messagingjms;

import jakarta.jms.ConnectionFactory;
import com.myJMS.messagingjms.model.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
// Active la détection des @JmsListener
@EnableJms
public class MessagingJmsApplication {

    @Bean
    public JmsListenerContainerFactory<?> myFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();

        // Applique la config auto de Spring Boot (converter, connexion, etc.)
        configurer.configure(factory, connectionFactory);

        // On pourrait surcharger certains paramètres ici si besoin
        return factory;
    }

    // Convertisseur pour envoyer nos objets Email en JSON (TextMessage)
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter =
                new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    public static void main(String[] args) {
        // Lancement de l’application
        System.out.println(" *** Demarrage : MessagingJmsApplication 1");
        ConfigurableApplicationContext context =
                SpringApplication.run(MessagingJmsApplication.class, args);

        System.out.println(" *** MessagingJmsApplication 2 : apres appel ConfigurableApplicationContext ");

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println(" *** MessagingJmsApplication 3 : apres appel context.getBean(JmsTemplate.class) ");

        // Envoi d’un message avec un POJO Email
        System.out.println(" *** MessagingJmsApplication 3 : Sending an email message.");
        jmsTemplate.convertAndSend(
                "mailbox",
                new Email("info@example.com", "Hello from Spring JMS")
        );

        System.out.println(" *** MessagingJmsApplication 4 : jmsTemplate.convertAndSend.");
    }
}
