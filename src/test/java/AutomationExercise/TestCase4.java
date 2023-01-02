package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase4 {


       static WebDriver driver;

        @BeforeClass
        public static void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    @Test
    public void test1() {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
     driver.get("http://automationexercise.com");
    //3. Verify that home page is visible successfully
     WebElement homePagevisible =driver.findElement(By.xpath("//*[@style='color: orange;']"));
     Assert.assertTrue(homePagevisible.isDisplayed());
    //4. Click on 'Signup / Login' button
     driver.findElement(By.xpath("//*[@href='/login']")).click();
    //5. Verify 'Login to your account' is visible
     WebElement display =driver.findElement(By.xpath("//*[text()='Login to your account']"));
     Assert.assertTrue(display.isDisplayed());
    //6. Enter correct email address and password
     driver.findElement(By.xpath("//*[@type='email']")).sendKeys("ozcanmuhammet298@gmail.com");
     driver.findElement(By.xpath("//*[@type='password']")).sendKeys("145301.Mk");
    //7. Click 'login' button
     driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
    //8. Verify that 'Logged in as username' is visible
     WebElement userDisplay = driver.findElement(By.xpath("//*[text()='Muhammet']"));
     Assert.assertTrue(userDisplay.isDisplayed());
    //9. Click 'Logout' button
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[1]")).click();
    //10. Verify that user is navigated to login page
        WebElement homePagevisible2 =driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(homePagevisible2.isDisplayed());
    }
}