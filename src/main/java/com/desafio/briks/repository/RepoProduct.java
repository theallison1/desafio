package com.desafio.briks.repository;

import com.desafio.briks.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProduct extends JpaRepository<Product,Integer> {
}
