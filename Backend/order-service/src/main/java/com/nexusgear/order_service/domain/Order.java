package com.nexusgear.order_service.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 'order' es una palabra reservada en SQL, por eso usamos 'orders'.
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Guardaremos el ID del usuario que hizo la orden.
    // Más adelante, esto se conectará con el user-auth-service.
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING) // Guarda el estado como texto (e.g., "PENDING")
    @Column(nullable = false)
    private OrderStatus status;

    // Relación "Uno a Muchos": Una Order tiene muchos OrderItems.
    // cascade = CascadeType.ALL: Si guardamos/borramos una Order, se guardan/borran sus items.
    // orphanRemoval = true: Si quitamos un item de la lista, se borra de la DB.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    // Getters, Setters, etc.
    // ... (puedes generarlos con tu IDE)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}