package com.threads.concurrency.Services;

import com.threads.concurrency.Entities.*;
import com.threads.concurrency.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class ChefService {

    @Autowired
    private ChefRepository chefRepository;

    // Method to save a new chef
    public Chef saveChef(Chef chef) {
        return chefRepository.save(chef);
    }

    // Method to retrieve all chefs with pagination and caching
    @Cacheable("chefs")
    public Page<Chef> getAllChefs(Pageable pageable) {
        return chefRepository.findAll(pageable);
    }

    // Method to retrieve a chef by ID
    public Chef getChefById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    // Method to delete a chef by ID
    public void deleteChefById(Long id) {
        chefRepository.deleteById(id);
    }
}
