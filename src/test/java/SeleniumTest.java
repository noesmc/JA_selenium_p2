import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public static void openSite() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement detailButton = driver.findElement(By.cssSelector("div>button[id='details-button']"));
        detailButton.click();
        WebElement redirectLink = driver.findElement(By.cssSelector(".small-link[id='proceed-link']"));
        redirectLink.click();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store",
            "Redirection to the page did not occur");
        driver.quit();
    }

    @Test
    public static void rubberDucksRedirection() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement detailButton = driver.findElement(By.cssSelector("div>button[id='details-button']"));
        detailButton.click();
        WebElement redirectLink = driver.findElement(By.cssSelector(".small-link[id='proceed-link']"));
        redirectLink.click();
        WebElement rubberDucksButton = driver.findElement
            (By.xpath("//div[@id='site-menu-wrapper']//a[text()='Rubber Ducks']"));
        rubberDucksButton.click();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store",
            "Redirection to the page did not occur");
        driver.quit();
    }

    @Test
    public static void subcategoryRedirection() {
        WebDriver driver = new ChromeDriver();
        Actions builder = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement detailButton = driver.findElement(By.cssSelector("div>button[id='details-button']"));
        detailButton.click();
        WebElement redirectLink = driver.findElement(By.cssSelector(".small-link[id='proceed-link']"));
        redirectLink.click();
        WebElement rubberDucksButton = driver.findElement
            (By.xpath("//div[@id='site-menu-wrapper']//a[text()='Rubber Ducks']"));
        builder.moveToElement(rubberDucksButton).perform();
        WebElement subcategoryButton = driver.findElement
            (By.xpath("//div[@id='site-menu-wrapper']//a[text()='Subcategory']"));
        subcategoryButton.click();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store",
            "Redirection to the page did not occur");
        driver.quit();
    }

    @Test
    public static void homePageRedirection() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement detailButton = driver.findElement(By.cssSelector("div>button[id='details-button']"));
        detailButton.click();
        WebElement redirectLink = driver.findElement(By.cssSelector(".small-link[id='proceed-link']"));
        redirectLink.click();
        WebElement rubberDucksButton = driver.findElement
            (By.xpath("//div[@id='site-menu-wrapper']//a[text()='Rubber Ducks']"));
        rubberDucksButton.click();
        WebElement homePageButton = driver.findElement
            (By.xpath("//div[@id='site-menu-wrapper']//i[@title='Home']"));
        homePageButton.click();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store",
            "Redirection to the page did not occur");
        driver.quit();
    }
}
