package com.example.inventory.repositories;

import com.example.inventory.model.Feedstock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedstockRepository extends JpaRepository<Feedstock, Long> {
}
