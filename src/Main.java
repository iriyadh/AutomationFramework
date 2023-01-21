import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Main {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        String currentDir = System.getProperty("user.dir");
        //System.out.println(currentDir);
        String path = currentDir + "\\Resources\\chromedriver.exe";
        //System.out.println(path);
        System.setProperty("webdriver.chrome.driver",path);

        ChromeOptions options = new ChromeOptions();
        Map <String, Object > prefs = new HashMap<String, Object>();
        Map <String, Object > profile = new HashMap<String, Object>();
        Map <String, Integer > contentSettings = new HashMap<String, Integer>();

        //0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile",profile);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[3]/h5")).click();
        ArrayList <String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //Thread.sleep(3000);
        driver.switchTo().window(tabs.get(0));
        //Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys("egg");
        //Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys(Keys.ENTER);
        //Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/section/div/div/div/div/section/div[3]/div[2]/div[1]/div/section/p")).click();
        //Thread.sleep(1000);

        driver.navigate().back();
        String text = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/section/div/div/div[1]/div/div/h2/span[2]")).getText();
        System.out.println(text);
    }
}
