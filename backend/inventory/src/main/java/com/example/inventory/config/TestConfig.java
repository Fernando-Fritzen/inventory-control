package com.example.inventory.config;

import com.example.inventory.model.Feedstock;
import com.example.inventory.model.Product;
import com.example.inventory.repositories.FeedstockRepository;
import com.example.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FeedstockRepository feedstockRepository;

    @Override
    public void run(String... args) throws Exception {

        Feedstock f1 = new Feedstock(null, "pedra", 5);
        Feedstock f2 = new Feedstock(null, "madeira", 3);
        Feedstock f3 = new Feedstock(null, "aço", 8);

        Product p1 = new Product(null, "Mesa", 145.20);
        Product p2 = new Product(null, "fffff", 155.4);
        Product p3 = new Product(null, "Panela", 55.5);

        feedstockRepository.saveAll(Arrays.asList(f1, f2, f3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3));

        p1.getFeedstocks().add(f2);
        p1.getFeedstocks().add(f1);
        p2.getFeedstocks().add(f1);
        p3.getFeedstocks().add(f3);

        productRepository.saveAll(Arrays.asList(p1,p2,p3));
    }
}
