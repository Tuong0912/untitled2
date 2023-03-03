package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements IProduct{
    List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        products.set(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).id() == id){
                return products.get(i);
            }
        }
        return null;
    }
}
