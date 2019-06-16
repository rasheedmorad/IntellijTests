package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Common {
    protected String MetricSite = "https://www.metric-conversions.org";
    protected WebDriver driver;

    // General function that receive site and open it by chrome driver
    public boolean openSiteByChromDriver(String site) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDev\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get(site);
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.print("Failed to open the site with chrom");
            return false;
        }
        return true;
    }

    // General Function that convert Values
    public String convert_From_To(String from, String to, String temp) {
        String result = null;
        driver.findElement(By.cssSelector("input[id=queryFrom]")).sendKeys(from);// insert the first type
        try {
            TimeUnit.SECONDS.sleep(2);

            driver.findElement(By.cssSelector("input[id=queryTo]")).sendKeys(to);// insert the second type
            TimeUnit.SECONDS.sleep(1);
            driver.findElements(By.cssSelector("input[class=argument]")).get(0).sendKeys(temp);// insert the value that
            // you want to convert
            driver.findElements(By.cssSelector("a[class=\"convert greenButton\"]")).get(0).click();
            result = driver.findElement(By.cssSelector("p[id=answer]")).getText().split("=")[1];// save the result
            TimeUnit.SECONDS.sleep(2);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        return result;

    }
}
