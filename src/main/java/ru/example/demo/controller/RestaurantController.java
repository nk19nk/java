package ru.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.entity.Restaurant;
import ru.example.demo.service.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/")
    public String listRestaurants(Model model) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurant-list";
    }

    @GetMapping("/new")
    public String createRestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant-form";
    }

    @PostMapping("/save")
    public String saveRestaurant(@ModelAttribute Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
        return "redirect:/restaurants/";
    }

    @PostMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurants/";
    }
}

