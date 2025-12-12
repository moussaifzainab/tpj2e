package com.example.activemq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.activemq.jms.MyJmsPublisher;
import com.example.activemq.models.Company;
import com.example.activemq.models.Product;

@SpringBootApplication
public class SpringActiveMqTopicProducerApplication implements CommandLineRunner {

    @Autowired
    MyJmsPublisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(SpringActiveMqTopicProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Apple
        Product iphoneX = new Product("Iphone X");
        Product iPadPro = new Product("IPadPro");
        List<Product> appleProducts =
                new ArrayList<>(Arrays.asList(iphoneX, iPadPro));
        Company apple = new Company("Apple", appleProducts);
        publisher.send(apple);

        // Samsung
        Product galaxySx = new Product("Galaxy SXX");
        Product gearSy = new Product("Gear YYY");
        List<Product> samsungProducts =
                new ArrayList<>(Arrays.asList(galaxySx, gearSy));
        Company samsung = new Company("Samsung", samsungProducts);
        publisher.send(samsung);
    }
}
