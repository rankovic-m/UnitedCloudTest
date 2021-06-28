import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/qwertify/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,30);

        driver.get("https://qa-interview.united.cloud/login");

        Thread.sleep(1000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("milica.rankovic");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Lozinka123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        System.out.println("User is logged in!");
        Thread.sleep(3000);
        createAccount(driver);
        System.out.println("Account created!");
        deleteAccount(driver);
        System.out.println("The account has been deleted!");
        Thread.sleep(3000);
        driver.close();
        System.out.println("The test was successful!");
    }

    public static void createAccount(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create new profile')]"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='profile-name']")).sendKeys("Milica");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(),'18+')]")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement e1 = driver.findElement(By.xpath("//input[@id='year']"));
        js.executeScript("arguments[0].scrollIntoView();", e1);
        e1.sendKeys("1997");
        Thread.sleep(2000);
        WebElement e2 = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/label[1]/div[1]/img[1]"));
        js.executeScript("arguments[0].scrollIntoView();", e2);
        e2.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Create profile')]")).click();
        Thread.sleep(3000);
    }

    public static void deleteAccount(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Delete profile')]")).click();

    }

}
