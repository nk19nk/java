package ru.example.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.entity.Menu;
import ru.example.demo.repository.MenuRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Menu> getMenusByRestaurantId(Integer restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }

    @Transactional
    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Transactional
    public void deleteMenu(Integer id) {
        menuRepository.deleteById(id);
    }
}

