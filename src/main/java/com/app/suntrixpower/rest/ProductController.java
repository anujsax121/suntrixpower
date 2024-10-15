package com.app.suntrixpower.rest;

import com.app.suntrixpower.model.ProductDTO;
import com.app.suntrixpower.model.ProductResponse;
import com.app.suntrixpower.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<ProductResponse> getIndexPage(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        Page<ProductDTO> productPage = productService.getProductList(page, size);
        return  new ResponseEntity<ProductResponse>(ProductResponse.builder()
                .total(productPage.getTotalPages())
                .results(productPage.getContent())
                .size(productPage.getTotalElements())
                .currentPage(page)
                .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
       return new ResponseEntity<String>("Product has been created successfully",
               HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content if the deletion is successful
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String id) {
        return new ResponseEntity<ProductDTO>(productService.getProduct(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO,
                                         @PathVariable(value = "id") String id) {
        return new ResponseEntity<>(productService.update(productDTO, id), HttpStatus.OK);
    }

}
