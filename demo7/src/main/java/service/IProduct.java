package service;

import model.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();
    void add(Product product);
    void update(int id , Product product);
    void delete(int id);

    Product findProductById(int id);
}
