package ru.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.entity.Menu;
import ru.example.demo.service.MenuService;

import java.util.List;

@Controller
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/")
    public String listMenus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "menu-list";
    }

    @GetMapping("/new")
    public String createMenuForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "menu-form";
    }

    @PostMapping("/save")
    public String saveMenu(@ModelAttribute Menu menu) {
        menuService.addMenu(menu);
        return "redirect:/menu/";
    }

    @PostMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Integer id) {
        menuService.deleteMenu(id);
        return "redirect:/menu/";
    }
}

