package ru.gb.springbootapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.model.ProductRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class RepositoryController {

    private final ProductRepository repo;

    @GetMapping("/")
    public String showProductList(Model model) {
        model.addAttribute("list", repo.getProductList());
        return "productlist";
    }

    @GetMapping(path = "/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping(path = "/add")
    public String processAddForm(Product product) {
        repo.add(product);
        return "redirect:/products/";
    }

    @GetMapping(path = "/{id}")
    public String showProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", repo.get(id).get());
        return "product";
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam long id) {
        repo.remove(id);
        return "redirect:/products/";
    }

}
