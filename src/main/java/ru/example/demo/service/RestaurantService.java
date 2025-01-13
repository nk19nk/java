package ru.example.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.entity.Restaurant;
import ru.example.demo.repository.RestaurantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repository;

    @Transactional(readOnly = true)
    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }

    @Transactional
    public void addRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Transactional
    public void deleteRestaurant(Integer id) {
        repository.deleteById(id);
    }
}

