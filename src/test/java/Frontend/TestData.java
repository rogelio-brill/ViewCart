package Frontend;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "localization-data")
    Object[][] locationsData(){
        return new Object[][] {
                {"us"},
                {"uk"},
                {"de"},
                {"au"}
        };
    }

    @DataProvider(name = "quantity-data")
    Object[][] quantityData(){
        return new Object[][] {
                {"us", "2"},
                {"uk", "3"},
                {"de", "4"},
                {"au", "5"}
        };
    }

    @DataProvider(name = "search-item-data")
    Object[][] searchItemData(){
        return new Object[][] {
                {"us", "iphone"},
                {"uk", "chair"},
                {"de", "iphone"},
                {"au", "laptop"}
        };
    }

    @DataProvider(name = "over-quantity-data")
    Object[][] overQuantityData(){
        return new Object[][] {
                {"us", "2000000"},
                {"uk", "30000000"},
                {"de", "400000000"},
                {"au", "5000000000"}
        };
    }

}
