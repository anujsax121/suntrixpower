package com.app.suntrixpower.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private String productCategory;
    private String productName;
    private Long rating;
    private Long quality;
    private Long maximumProducts;
    private Long minimumProducts;
    private String createdBy;
    private LocalDateTime createdDate;
    private Long phoneNumber;
}
