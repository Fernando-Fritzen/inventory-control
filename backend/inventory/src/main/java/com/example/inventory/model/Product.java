package com.example.inventory.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private Double price;

    @ManyToMany @Fetch(FetchMode.JOIN)
    @JoinTable(name = "tb_product_feedstock",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "feedstock_id"))
    private List<Feedstock> feedstocks = new ArrayList<>();

    public Product() {

    }

    public Product(Long code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Product(Long code, String name, Double price, List<Feedstock> feedstocks) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.feedstocks = feedstocks;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Feedstock> getFeedstocks() {
        return feedstocks;
    }

    public void setFeedstocks(List<Feedstock> feedstocks) {
        this.feedstocks = feedstocks;
    }
}
