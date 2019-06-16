package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/* convert  values
*/
@Test
public class Test1 extends Common {
    // convert from Celsius to Celsius
    @Test
    private void converts_temperature() {
        Assert.assertTrue(openSiteByChromDriver(MetricSite));
        String res = convert_From_To("Celsius", "Fahrenheit", "100");
        Assert.assertEquals(res.trim(), "212.0000°F", "Expected the result to be : " + res);

    }

    // convert from Meters to Feet
    @Test
    private void converts_Meters() {
        Assert.assertTrue(openSiteByChromDriver(MetricSite));
        String res = convert_From_To("Meters", "Feet", "100");
        Assert.assertEquals(res.trim(), "328ft 1.007880in", "Expected the result to be: " + res);
    }

    // convert from Ounces to Grams
    @Test
    private void converts_Weight() {
        Assert.assertTrue(openSiteByChromDriver(MetricSite));
        String res = convert_From_To("Ounces", "Grams", "100");
        Assert.assertEquals(res.trim(), "2834.952g", "Expected the result to be : " + res);

    }


}
