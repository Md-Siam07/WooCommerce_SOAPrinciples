package com.wstutorial.ws;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.productservice.*;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    List<Product> products = new ArrayList<>();

    public ProductRepository() {
        Product product1 = new Product();
        product1.setHeader(new ProductHeader());
        product1.getHeader().setId(1l);
        product1.getHeader().setLabel("Rangpur er hari vanga aam");
        product1.getHeader().setPrice(100l);
        product1.setStock(1000l);
        product1.setSellerId(1);

        Product product2 = new Product();
        product2.setHeader(new ProductHeader());
        product2.getHeader().setId(2l);
        product2.getHeader().setLabel("Rajshahi er lengra aam");
        product2.getHeader().setPrice(80l);
        product2.setStock(100l);
        product2.setSellerId(1);

        Product product3 = new Product();
        product3.setHeader(new ProductHeader());
        product3.getHeader().setId(3l);
        product3.getHeader().setLabel("Macbook air 2020");
        product3.getHeader().setPrice(99500l);
        product3.setStock(75l);
        product3.setSellerId(2);

        Product product4 = new Product();
        product4.setHeader(new ProductHeader());
        product4.getHeader().setId(4l);
        product4.getHeader().setLabel("macbook pro m2");
        product4.getHeader().setPrice(132000l);
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
        System.out.println("get called");
        for(Product c: products) {
            if(c.getHeader().getId() == id) {
                return c;
            }
        }
        System.out.println("can not get: product not found with id: " + id);
        return null;
    }

//    public AcknowledgementCode deleteProductById(Long id) {
//        System.out.println("delete called");
//        for(Product c: products) {
//            if(c.getHeader().getId() == id) {
//                products.remove(c);
//                return AcknowledgementCode.DELETED;
//            }
//        }
//        System.out.println("can not delete: product not found with id: " + id);
//        return AcknowledgementCode.FAILED;
//    }

    public AcknowledgementCode updateProductById(Long id, Product product) {
        if (id == null || product == null) {
            System.out.println("Invalid input: id or product is null");
            return AcknowledgementCode.FAILED;
        }

        for (int i = 0; i < products.size(); i++) {
            Long productId = products.get(i).getHeader().getId();
            if (productId.equals(id)) {
                products.set(i, product);
                return AcknowledgementCode.UPDATED;
            }
        }
        System.out.println("Cannot update: product not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }


    public void createNewProduct(Product product) {
        product.getHeader().setId(products.size()+1);
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
//        System.out.println("called" + productId + " " + quantity);
        Product product = new Product();
        for(Product p: products) {
            if(p.getHeader().getId() == productId) {
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
