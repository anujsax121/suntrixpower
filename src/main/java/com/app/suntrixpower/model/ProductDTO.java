package com.app.suntrixpower.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private String id;
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
