package com.example.inventory.controller;

import com.example.inventory.model.Feedstock;
import com.example.inventory.model.Product;
import com.example.inventory.repositories.ProductRepository;
import com.example.inventory.services.FeedstockService;
import com.example.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/feedstocks")
public class FeedstockController {

    @Autowired
    private FeedstockService service;


    @GetMapping
    public ResponseEntity<List<Feedstock>> findAll() {
        List<Feedstock> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feedstock> findById(@PathVariable Long id) {
        Feedstock obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Feedstock> insert(@RequestBody Feedstock feedstock) {
        feedstock = service.insert(feedstock);
        return ResponseEntity.ok().body(feedstock);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Feedstock> update(@PathVariable Long id, @RequestBody Feedstock feedstock) {
        feedstock = service.update(id, feedstock);
        return ResponseEntity.ok().body(feedstock);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
