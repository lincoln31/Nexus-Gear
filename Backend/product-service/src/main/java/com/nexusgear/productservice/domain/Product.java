package com.nexusgear.productservice.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "products")
public class Product {

    // @Id: Marca este campo como la clave primaria de la tabla.
    // @GeneratedValue: Configura la estrategia de generación de la clave primaria (autoincremental).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Especifica propiedades de la columna, como que no puede ser nula.
    @Column(nullable = false)
    private String name;

    @Column(length = 1000) // Permite una descripción más larga
    private String description;

    // Usamos BigDecimal para el dinero. ¡Es una buena práctica para evitar errores de redondeo con float/double!
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    private String category;

    @Column(name = "image_url")
    private String imageUrl;

    // JPA requiere un constructor sin argumentos.
    public Product() {
    }
    // Getters y Setters (puedes generarlos con tu IDE o usar Lombok si lo prefieres)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
