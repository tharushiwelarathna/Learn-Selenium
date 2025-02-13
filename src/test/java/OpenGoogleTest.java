import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGoogleTest {

    @Test
    public void googleTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //open wuna browser eka close karana command eka me - driver.quit();
        //driver.quit();

        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
    }
}
