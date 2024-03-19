package com.desafio.briks.service;

import com.desafio.briks.client.RestClientApi;
import com.desafio.briks.model.Category;
import com.desafio.briks.model.Product;
import com.desafio.briks.repository.RepoProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct {
    private final RepoProduct repoProduct;
    private final RestClientApi restClientApi;
    @Autowired
    public ServiceProduct(RepoProduct repoProduct, RestClientApi restClientApi) {
        this.repoProduct = repoProduct;
        this.restClientApi = restClientApi;
    }

    public Page<Product> findAll(Pageable pageable) {
        return repoProduct.findAll(pageable);
    }

    public Product save(Product product) {
        return repoProduct.save(product);
    }

    public Product findById(Integer id) {
        return repoProduct.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        repoProduct.deleteById(id);
    }
    public Product updateProduct(Integer id, Product updatedProduct) {
        Product existingProduct = repoProduct.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Update the fields of the existing product with the fields of the updated product
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());
        existingProduct.setCodeCategoria(updatedProduct.getCodeCategoria());


        // Save the updated product
        return repoProduct.save(existingProduct);
    }
    public List<Category> categoryByApi () throws JsonProcessingException {

        List<Category> responseCategory =restClientApi.fetchDataFromApi();
        return responseCategory;
    }

}
