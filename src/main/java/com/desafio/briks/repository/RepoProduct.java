package com.desafio.briks.repository;

import com.desafio.briks.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RepoProduct extends PagingAndSortingRepository<Product,Integer> {
    List<Product> findByIdAndNameAndPrice(int id,String name,Double price,Pageable pageable);
    Page<Product> findByName(String name, Pageable pageable);


    Page<Product> findById(Integer id, Pageable pageable);
    Product findById(Integer id);

    void deleteById(Integer id);

    Product save(Product existingProduct);
}
