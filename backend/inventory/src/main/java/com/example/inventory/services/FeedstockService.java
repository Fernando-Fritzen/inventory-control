package com.example.inventory.services;

import com.example.inventory.model.Feedstock;
import com.example.inventory.repositories.FeedstockRepository;
import com.example.inventory.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedstockService {

    @Autowired
    private FeedstockRepository repository;

    public List<Feedstock> findAll() {
        return repository.findAll();
    }

    public Feedstock findById(Long id) {
        Optional<Feedstock> obj = repository.findById(id);
        return obj.orElseThrow(
                () -> new EntityNotFoundException("Id not found " + id)
        );
    }

    public Feedstock insert(Feedstock feedstock) {
        return repository.save(feedstock);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Feedstock update(Long id, Feedstock obj) {
        Feedstock entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Feedstock entity, Feedstock obj) {
        entity.setName(obj.getName());
        entity.setQuantity(obj.getQuantity());
    }
}
