package com.nexusgear.productservice;

import com.nexusgear.productservice.domain.Product;
import com.nexusgear.productservice.repository.ProductRepository;
import com.nexusgear.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class): Activa la magia de Mockito en esta clase de test.
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    // @Mock: Crea un objeto falso (un mock) del ProductRepository.
    // Este mock no se conectará a la base de datos; nosotros le diremos cómo comportarse.
    @Mock
    private ProductRepository productRepository;

    // @InjectMocks: Crea una instancia real de ProductService e intenta inyectar
    // los mocks definidos en esta clase (en este caso, el productRepository).
    @InjectMocks
    private ProductService productService;

    private Product product1;
    private Product product2;

    // @BeforeEach: Este método se ejecutará antes de cada test (@Test).
    // Es perfecto para configurar datos de prueba comunes.
    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setId(1L);
        product1.setName("Teclado Test");
        product1.setPrice(new BigDecimal("99.99"));

        product2 = new Product();
        product2.setId(2L);
        product2.setName("Ratón Test");
        product2.setPrice(new BigDecimal("49.99"));
    }

    @Test
    void whenFindAllProducts_shouldReturnProductList() {
        // 1. Arrange (Preparar)
        // Le decimos a nuestro mock cómo debe comportarse.
        // "Cuando alguien llame al método findAll() del productRepository,
        // entonces devuelve una lista que contiene product1 y product2."
        when(productRepository.findAll()).thenReturn(List.of(product1, product2));

        // 2. Act (Actuar)
        // Llamamos al método que queremos probar.
        List<Product> foundProducts = productService.findAllProducts();

        // 3. Assert (Verificar)
        // Verificamos que el resultado es el que esperamos.
        assertNotNull(foundProducts); // La lista no debe ser nula.
        assertEquals(2, foundProducts.size()); // El tamaño de la lista debe ser 2.
        assertEquals("Teclado Test", foundProducts.get(0).getName()); // El nombre del primer producto debe ser el esperado.

        // Opcional pero buena práctica: verificar que el método del mock fue llamado.
        // "Verifica que el método findAll() del productRepository fue llamado exactamente 1 vez."
        verify(productRepository, times(1)).findAll();
    }
    @Test
    void whenFindProductById_withValidId_shouldReturnProduct() {
        // Arrange
        // "Cuando alguien llame a findById() con el ID 1,
        // entonces devuelve un Optional que contiene a product1."
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        // Act
        Product foundProduct = productService.findProductById(1L);

        // Assert
        assertNotNull(foundProduct);
        assertEquals(1L, foundProduct.getId());
        assertEquals("Teclado Test", foundProduct.getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void whenFindProductById_withInvalidId_shouldThrowException() {
        // Arrange
        // "Cuando alguien llame a findById() con el ID 99,
        // entonces devuelve un Optional vacío (no encontró nada)."
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        // Verificamos que al ejecutar el método, se lanza una excepción del tipo RuntimeException.
        // Esta es la forma de probar que nuestro manejo de errores funciona.
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.findProductById(99L);
        });

        // Verificamos que el mensaje de la excepción es el que esperamos.
        String expectedMessage = "Product not found with id: 99";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        verify(productRepository, times(1)).findById(99L);
    }
}