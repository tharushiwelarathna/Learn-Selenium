import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

    //Open google
    //Go to Google home page


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //open wuna browser eka close karana command eka me
        driver.quit();


    }
}
