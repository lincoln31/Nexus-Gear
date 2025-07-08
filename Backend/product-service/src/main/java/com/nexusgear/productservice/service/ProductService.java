package com.nexusgear.productservice.service;

import com.nexusgear.productservice.domain.Product;
import com.nexusgear.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Usamos inyección de dependencias por constructor. Es la mejor práctica.
    // Spring verá que este constructor necesita un ProductRepository y nos lo proporcionará automáticamente.
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        // findById devuelve un Optional. Si no encuentra el producto, lanzamos una excepción.
        // Esto es un buen manejo de errores que veremos en acción más adelante.
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
