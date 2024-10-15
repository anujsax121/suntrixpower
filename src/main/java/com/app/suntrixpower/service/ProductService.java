package com.app.suntrixpower.service;

import com.app.suntrixpower.entity.Product;
import com.app.suntrixpower.error.ProductNotFoundException;
import com.app.suntrixpower.mapper.ProductMapper;
import com.app.suntrixpower.model.ProductDTO;
import com.app.suntrixpower.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public void create(ProductDTO productDTO) {
        productRepository.save(ProductMapper.toEntity(productDTO));
    }

    public Page<ProductDTO> getProductList(int page, int size) {
        logger.info("Retrieving product details");
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        // Convert Page<ProductEntity> to Page<ProductDTO>
        logger.info("Retrieved product details");
        return productPage.map(ProductMapper::toDTO);
    }

    public void delete(String id) {
        logger.info("Deleting product details {}", id);
        productRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        productRepository.deleteById(UUID.fromString(id));
        logger.info("Deleted product details");
    }

    public ProductDTO getProduct(String id) {
        logger.info("Retrieving product details by id {}", id);
        return ProductMapper.toDTO(productRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ProductNotFoundException("Product is not Found")));
    }

    public ProductDTO update(ProductDTO productDTO, String id) {
        logger.info("Updating product details by id {}", id);
        productRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ProductNotFoundException("Product is not Found"));
        Product product = ProductMapper.toEntity(productDTO);
        product.setId(UUID.fromString(id));
        product = productRepository.save(product);
        logger.info("Updated product details by id {}", id);
        return ProductMapper.toDTO(product);
    }

}
