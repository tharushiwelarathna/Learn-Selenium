import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("129");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); //open wechcha browser eka desktop size ekatama fit krla denna kiynne mehemai
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000); // thappara ganak wait karanna onanm mehema dala krnna puluwan
    }
    @Test
    public void textBoxTests(){
        //01) Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys(" Tharushi Nirmani");

        //02) Append Country to this City.
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //03) Verify if text box is disabled
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println(" Is Text Box Enabled :" + enabled );


        //04) Clear the typed text.
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05) Retrieve the typed text.
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //06) Type email and Tab. Confirm control moved to next element.
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("nirmanitharushi1@gmail.com" + Keys.TAB + "Confirm control moved to next element.");
         }



}
