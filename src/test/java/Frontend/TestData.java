package Frontend;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "quantity-data")
    Object[][] quantityData(){
        return new Object[][] {
                {"us", "2"},
                {"uk", "3"},
                {"de", "4"}
        };
    }

    @DataProvider(name = "over-quatnity-data")
    Object[][] overQuantityData(){
        return new Object[][] {
                {"us", "200000"},
                {"us", "3000000"},
                {"us", "40000"}
        };
    }

}
