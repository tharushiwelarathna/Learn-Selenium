import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    //me text eka wenna kalin yamkisi deyak wenna ona nm mehema @BeforeMethod annotation eka dala declare kara ganna puluwan.
    //yata @Test eka wenna kalin meka wela thama araka wenne.
//    @Test
//    public void LinkTest(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.leafground.com/link.xhtml");
//    }
    //mehema test eka athule danne nthuwa .

    WebDriver  driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //open wechcha browser eka desktop size ekatama fit krla denna kiynne mehemai
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest(){
        //01) Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back(); // selenium walin back wenna liynne mehemai

        //02) Find my destination
       WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL without clicking me."));
       String path = whereToGo.getAttribute("href");
       System.out.println("This link is going to: " + path);

        //03) Am I broken link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if ( title.contains("404")) {
            System.out.println("The link is broken");
        }else {
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //04) Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();
        
        //05) Count page Links
        List<WebElement> countFullPageLinks=  driver.findElements(By.tagName("a"));
        int pageLinkCount =  countFullPageLinks.size();
        System.out.println("Counts of full page links:" + pageLinkCount);

        //06) count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Counts of Layout Links: " + countOfLayoutLinks.size());
    }

}
