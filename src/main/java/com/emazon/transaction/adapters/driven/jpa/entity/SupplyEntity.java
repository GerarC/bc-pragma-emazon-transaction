package com.emazon.transaction.adapters.driven.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "supply")
public class SupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_id")
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}