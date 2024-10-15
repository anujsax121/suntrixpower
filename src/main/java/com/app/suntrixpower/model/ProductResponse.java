package com.app.suntrixpower.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {

    private int total;
    private boolean maxAllowedResultsReturned;
    private int currentPage;
    private long totalPages;
    private long size;
    private List<ProductDTO> results;
}
