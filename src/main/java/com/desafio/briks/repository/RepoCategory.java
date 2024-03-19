package com.desafio.briks.repository;

import com.desafio.briks.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCategory extends JpaRepository<Category,Integer> {
}
