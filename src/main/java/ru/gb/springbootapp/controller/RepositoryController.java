package ru.gb.springbootapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.model.ProductRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class RepositoryController {

    private final ProductRepository repo;

    @GetMapping("/")
    public String getProductListing(Model model) {
        model.addAttribute("list", repo.getProductList());
        return "productlist";
    }

    @GetMapping(path="/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping(path="/add")
    public String processForm(Product product) {
        repo.add(product);
        return "redirect:/products/";
    }

}
