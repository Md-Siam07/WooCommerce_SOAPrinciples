//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 12:52:06 AM BDT 
//


package com.wstutorial.ws.productservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wstutorial.ws.productservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wstutorial.ws.productservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateProductRequest }
     * 
     */
    public UpdateProductRequest createUpdateProductRequest() {
        return new UpdateProductRequest();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link CreateProductRequest }
     * 
     */
    public CreateProductRequest createCreateProductRequest() {
        return new CreateProductRequest();
    }

    /**
     * Create an instance of {@link DeleteProductRequest }
     * 
     */
    public DeleteProductRequest createDeleteProductRequest() {
        return new DeleteProductRequest();
    }

    /**
     * Create an instance of {@link GetProductRequest }
     * 
     */
    public GetProductRequest createGetProductRequest() {
        return new GetProductRequest();
    }

    /**
     * Create an instance of {@link GetProductsRequest }
     * 
     */
    public GetProductsRequest createGetProductsRequest() {
        return new GetProductsRequest();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link GetProductResponse }
     * 
     */
    public GetProductResponse createGetProductResponse() {
        return new GetProductResponse();
    }

    /**
     * Create an instance of {@link GetProductHeaderRequest }
     * 
     */
    public GetProductHeaderRequest createGetProductHeaderRequest() {
        return new GetProductHeaderRequest();
    }

    /**
     * Create an instance of {@link GetProductHeaderResponse }
     * 
     */
    public GetProductHeaderResponse createGetProductHeaderResponse() {
        return new GetProductHeaderResponse();
    }

    /**
     * Create an instance of {@link ProductHeader }
     * 
     */
    public ProductHeader createProductHeader() {
        return new ProductHeader();
    }

    /**
     * Create an instance of {@link UpdateProductStockRequest }
     * 
     */
    public UpdateProductStockRequest createUpdateProductStockRequest() {
        return new UpdateProductStockRequest();
    }

    /**
     * Create an instance of {@link GetProductsBySellerIdRequest }
     * 
     */
    public GetProductsBySellerIdRequest createGetProductsBySellerIdRequest() {
        return new GetProductsBySellerIdRequest();
    }

    /**
     * Create an instance of {@link Products }
     * 
     */
    public Products createProducts() {
        return new Products();
    }

}
