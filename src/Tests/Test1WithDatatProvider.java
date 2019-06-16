package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//I solved test1 by data provider too
@Test
public class Test1WithDatatProvider extends Common {
    ///*****************Test1 With Data Provider **********************************///
    @Test(dataProvider = "getData")
    public void Test1WithDataProvider(String p1, String p2, String p3) {
        Assert.assertTrue(openSiteByChromDriver(MetricSite));
        String value = null;
        System.out.println("Instance DataProvider Example: Data(" + p1 + ", " + p2 + ")");
        String res = convert_From_To(p1, p2, p3);
        switch (p1) {
            case "Celsius":
                value = "212.0000°F";
                break;
            case "Meters":
                value = "328ft 1.007880in";
                break;
            case "Ounces":
                value = "2834.952g";
                break;
        }
        Assert.assertEquals(res.trim(), value, "Expected the result to be : " + res);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"Ounces", "Grams", "100"}, {"Meters", "Feet", "100"}, {"Celsius", "Fahrenheit", "100"}};
    }
}
