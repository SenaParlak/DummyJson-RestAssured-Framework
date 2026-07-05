package data;

import com.senaparlak.restassured.models.product.CreateProductRequest;
import com.senaparlak.restassured.models.product.UpdateProductRequest;

import java.util.UUID;

public class ProductData {

    private ProductData(){

    }

    public static CreateProductRequest validProduct() {

        CreateProductRequest request = new CreateProductRequest();

        request.setTitle("Phone " + UUID.randomUUID());
        request.setDescription("Automation Test Product");
        request.setCategory("senaphones");
        request.setPrice(999);

        return request;
    }

    public static UpdateProductRequest validUpdateProduct(){

        UpdateProductRequest request = new UpdateProductRequest();
        request.setTitle("Updated Product");
        request.setDescription("Automation Test Product");
        request.setPrice(400);

        return request;
    }
}
