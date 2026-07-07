package data;

import com.senaparlak.restassured.models.product.CreateProductRequest;
import com.senaparlak.restassured.models.product.UpdateProductRequest;
import net.datafaker.Faker;

import java.util.UUID;

public class ProductData {

    private ProductData(){

    }

    private static final Faker faker = new Faker();

    public static CreateProductRequest validProduct() {

        CreateProductRequest request = new CreateProductRequest();

        request.setTitle(faker.commerce().productName());
        request.setDescription(faker.lorem().sentence());
        request.setCategory(faker.commerce().department());
        request.setPrice(faker.number().randomDouble(3, 54, 2000));

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
