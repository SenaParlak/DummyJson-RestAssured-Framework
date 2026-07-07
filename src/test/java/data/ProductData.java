package data;

import com.senaparlak.restassured.models.product.CreateProductRequest;
import com.senaparlak.restassured.models.product.UpdateProductRequest;
import net.datafaker.Faker;

public class ProductData {

    private ProductData(){

    }
    public class FakerUtils {

        private FakerUtils(){}

        public static final Faker FAKER = new Faker();
    }

    private static final Faker faker = new Faker();

    public static CreateProductRequest validProduct() {

        return CreateProductRequest.builder()
        .title(faker.commerce().productName())
        .description(faker.lorem().sentence())
        .category(faker.commerce().department())
        .price(faker.number().randomDouble(3, 54, 2000))
        .build();

    }

    public static UpdateProductRequest validUpdateProduct(){

        return UpdateProductRequest.builder()
                .title("Updated " + FakerUtils.FAKER.commerce().productName())
                .description(FakerUtils.FAKER.lorem().sentence())
                .price(FakerUtils.FAKER.number().numberBetween(200, 3000))
                .build();
    }
}
