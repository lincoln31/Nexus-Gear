package com.nexusgear.productservice.controller;

import com.nexusgear.productservice.domain.Product;
import com.nexusgear.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Inyectamos el servicio, igual que hicimos con el repositorio en el servicio.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @GetMapping: Mapea peticiones HTTP GET a la ruta base ("/api/products").
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    // @GetMapping("/{id}"): Mapea peticiones GET a "/api/products/{un_numero}".
    // @PathVariable: Extrae el valor de la URL (el id) y lo pasa como argumento al método.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
}
