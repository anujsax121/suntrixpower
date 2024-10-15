package com.app.suntrixpower.mapper;

import com.app.suntrixpower.entity.Product;
import com.app.suntrixpower.model.ProductDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductMapper {

    public static Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .productCategory(productDTO.getProductCategory())
                .productName(productDTO.getProductName())
                .rating(productDTO.getRating())
                .quality(productDTO.getQuality())
                .maximumProducts(productDTO.getMaximumProducts())
                .minimumProducts(productDTO.getMinimumProducts())
                .createdBy(productDTO.getCreatedBy())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
                String.valueOf(product.getId()),
                product.getProductCategory(),
                product.getProductName(),
                product.getRating(),
                product.getQuality(),
                product.getMaximumProducts(),
                product.getMinimumProducts(),
                product.getCreatedBy(),
                product.getCreatedDate(),
                product.getPhoneNumber()
        );
    }
}
