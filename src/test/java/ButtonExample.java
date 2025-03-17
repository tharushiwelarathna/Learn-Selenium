import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("129");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
        Dimension newSize = new Dimension(800, 600);    // dimension use krla window eke size eka change krganne mehemai
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");

    }

    @Test
    public void buttonTests(){
        //01. Click and confirm the title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual title same as expected");
        } else{
            System.out.println("Actual title not same as expected");
        } // meka conditional statement ekak nathuwath krnna puluwan testng walin me widiyta
//         Assert.assertEquals(actualTitle,expectedTitle,"Title miss matched");


        //03. Find the position of submit button
        driver.navigate().back();// apasse page ekata navigate wenwa.
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is : " + x + "Y position is : " + y);

        //04. Find the save button color
        WebElement buttonColor =  driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Button color is :" + color);

        //05. Find the height and width of button
        WebElement size =  driver.findElement(By.id("j_idt88:j_idt98"));
        int h = size.getSize().getHeight();
        int w = size.getSize().getWidth();
        System.out.println("Height is :" + h + "Width is: " + w);

        //06. Mouse over and confirm the color changed
//        driver.findElement(By.id("j_idt88:j_idt100")).




    }

}
