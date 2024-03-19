package com.desafio.briks.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    private int stock;
    @Column(name = "codecategoria")
    private String codeCategoria ;

    public Product() {
    }

    public Product(int id, String name, Double price, int stock, String codeCategoria) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.codeCategoria = codeCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodeCategoria() {
        return codeCategoria;
    }

    public void setCodeCategoria(String codeCategoria) {
        this.codeCategoria = codeCategoria;
    }
}
