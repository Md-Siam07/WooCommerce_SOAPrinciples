package com.wstutorial.ws;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.productservice.*;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    List<Product> products = new ArrayList<>();

    public ProductRepository() {
        Product product1 = new Product();
        product1.setId(1l);
        product1.setLabel("Rangpur er hari vanga aam");
        product1.setPrice(100l);
        product1.setStock(1000l);
        product1.setSellerId(1);

        Product product2 = new Product();
        product2.setId(2l);
        product2.setLabel("Rajshahi er lengra aam");
        product2.setPrice(80l);
        product2.setStock(100l);
        product2.setSellerId(1);

        Product product3 = new Product();
        product3.setId(3l);
        product3.setLabel("Macbook air 2020");
        product3.setPrice(99500l);
        product3.setStock(75l);
        product3.setSellerId(2);

        Product product4 = new Product();
        product4.setId(4l);
        product4.setLabel("macbook pro m2");
        product4.setPrice(132000l);
        product4.setStock(100l);
        product4.setSellerId(2);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

    }
    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        for(Product c: products) {
            if(c.getId() == id) {
                return c;
            }
        }
        System.out.println("can not delete: product not found with id: " + id);
        return null;
    }

    public AcknowledgementCode deleteProductById(Long id) {

        for(Product c: products) {
            if(c.getId() == id) {
                products.remove(c);
                return AcknowledgementCode.DELETED;
            }
        }
        System.out.println("can not delete: product not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }

    public AcknowledgementCode updateProductById(Long id, Product product) {
        if (id == null || product == null) {
            System.out.println("Invalid input: id or product is null");
            return AcknowledgementCode.FAILED;
        }

        for (int i = 0; i < products.size(); i++) {
            Long productId = products.get(i).getId();
            if (productId.equals(id)) {
                products.set(i, product);
                return AcknowledgementCode.UPDATED;
            }
        }
        System.out.println("Cannot update: product not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }


    public void createNewProduct(Product product) {
        product.setId(products.size()+1);
        products.add(product);
    }

    public List<Product> getProductsBySellerId(Long id) {
        List<Product> prods = new ArrayList<>();
        for(Product product: products) {
            if(product.getSellerId() == id) {
                prods.add(product);
            }
        }
        return prods;
    }

    public AcknowledgementCode updateProductStock(Long productId, Long quantity) {
        Product product = new Product();
        for(Product p: products) {
            if(p.getSellerId() == productId) {
                product = p;
            }
        }
        if(product.getStock() >= quantity) {
            product.setStock(product.getStock()-quantity);
            updateProductById(productId, product);
            return AcknowledgementCode.UPDATED;
        }
        return AcknowledgementCode.FAILED;
    }

}
