package providers;

import org.testng.annotations.DataProvider;

public class ProductDataProvider {

    @DataProvider (name = "productIds")
    public static Object[][] productIds(){
        return new Object[][]{
                {1},
                {9},
                {13},
                {22},
                {34}
        };
    }
}
