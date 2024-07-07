package Thuchanh;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCategory extends BaseTest {
    @Test
    public void addNewCategory() {
        driver.get("https://cms.anhtester.com/login");
        sleep(1);
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        inputUsername.sendKeys("admin@example.com");
        inputPassword.sendKeys("123456");
        buttonLogin.click();

        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Car Shop");
        sleep(1);
        driver.findElement(By.xpath("//button[@title='No Parent']")).click();
        driver.findElement(By.xpath("(//input[@aria-label='Search'])[1]")).sendKeys("Car");
        sleep(1);
        driver.findElement(By.xpath("(//span[text()='Car'])[1]")).click();
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("(//div[contains(text(),'Physical')])[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();
        sleep(1);
        driver.findElement(By.xpath("//label[contains(normalize-space(),'Banner')]//following-sibling::div//div//div//div[contains(normalize-space(),'Browse')]")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("iconCar");
        sleep(1);
        driver.findElement(By.xpath("//div[@title='iconCar.png']")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);
        driver.findElement(By.xpath("//label[contains(normalize-space(),'Icon')]//following-sibling::div//div//div//div[contains(normalize-space(),'Browse')]")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("BannerCar");
        sleep(1);
        driver.findElement(By.xpath("//div[@title='BannerCar.png']")).click();
        //driver.findElement(By.xpath("(//div[@class='aiz-file-box'])[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        sleep(3);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Car Shop");
        sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(5);

    }
    @Test
    public void verifyCategory(){
        driver.get("https://cms.anhtester.com/login");
        sleep(1);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");;
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        sleep(1);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Car Shop");
        sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(2);
        WebElement categoryName = driver.findElement(By.xpath("//td[contains(text(),'Car Shop')]"));
        System.out.println(categoryName);
        Assert.assertEquals(categoryName.getText(),"Car Shop","Name is displayed incorrect!");
        sleep(2);

    }
}
