// ProductServiceApplication.java
package com.nexusgear.productservice;

import com.nexusgear.productservice.domain.Product;
import com.nexusgear.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	// Este Bean se ejecutará una sola vez cuando la aplicación arranque.
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository repository) {
		return args -> {
			// Limpiamos por si acaso y añadimos datos frescos
			repository.deleteAll();

			Product p1 = new Product();
			p1.setName("Teclado Mecánico Keychron K2");
			p1.setDescription("Teclado 75% inalámbrico con switches Gateron Brown.");
			p1.setPrice(new BigDecimal("99.99"));
			p1.setStockQuantity(50);
			p1.setCategory("Teclados");
			p1.setImageUrl("url_a_imagen_teclado.jpg");

			Product p2 = new Product();
			p2.setName("Ratón Logitech MX Master 3S");
			p2.setDescription("Ratón ergonómico de alta precisión con scroll electromagnético.");
			p2.setPrice(new BigDecimal("109.90"));
			p2.setStockQuantity(75);
			p2.setCategory("Ratones");
			p2.setImageUrl("url_a_imagen_raton.jpg");

			repository.save(p1);
			repository.save(p2);
		};
	}
}