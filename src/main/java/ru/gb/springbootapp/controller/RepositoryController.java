package ru.gb.springbootapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class RepositoryController {

    private final ProductService productService;

    @GetMapping("/")
    public String showProductList(Model model,
                                  @RequestParam(defaultValue = "asc", required = false) String sort) {

        model.addAttribute("list", productService
                .getSortedProductList(sort.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC));
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
        productService.add(product);
        return "redirect:/products/";
    }

    @GetMapping(path = "/{id}")
    public String showProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam long id) {
        productService.remove(id);
        return "redirect:/products/";
    }

    @GetMapping(path = "/edit")
    public String edit(Model model, @RequestParam long id) {
        model.addAttribute("product", productService.findById(id));
        return "edit-product";
    }

    @PostMapping(path = "/edit")
    public String processEditForm(Product product) {
        productService.save(product);
        return "redirect:/products/";
    }

}
