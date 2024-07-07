package Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {
    @Test

    public void testJavascriptExecutor01() {
        driver.get("https://cms.anhtester.com/");
        sleep(1);
        //By buttonCloseWelcomeDialog = By.xpath("//button[@data-key='website-popup']");
        //By menuBlogs = By.xpath("//a[normalize-space()='Blogs']");
        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement buttonApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));
        buttonCloseWelcomeDialog.click();
        buttonViewAllCategories.click();
        //Su dung Javascript Executor de thuc thi click menu Blogs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("argument[0].click();",)
        // js.executeScript("arguments[0].click();", menuBlogs);


    }

    @Test
    public void testJavascriptExecutor02() {
        driver.get("https://cms.anhtester.com/");
        sleep(1);
        //By buttonCloseWelcomeDialog = By.xpath("//button[@data-key='website-popup']");
        //By menuBlogs = By.xpath("//a[normalize-space()='Blogs']");
        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement buttonApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));
        buttonCloseWelcomeDialog.click();

        //Su dung Javascript Executor de thuc thi click menu Blogs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));
        js.executeScript("arguments[0].setAttribute('value','Qua Tet');", inputSearch);
        WebElement buttonSearch = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        buttonSearch.click();
        sleep(2);

    }

    @Test
    public void testJavascriptExecutor03() {
        driver.get("https://cms.anhtester.com/");
        sleep(1);
        //By buttonCloseWelcomeDialog = By.xpath("//button[@data-key='website-popup']");
        //By menuBlogs = By.xpath("//a[normalize-space()='Blogs']");
        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement buttonApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));


        //Su dung Javascript Executor de thuc thi click menu Blogs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Cuon chuot den vi tri Top cua phan tu
        //js.executeScript("arguments[0].scrollIntoView(true);", buttonViewAllCategories);
        //buttonViewAllCategories.click();
        //js.executeScript("window.scrollTo(0,500)");
        //sleep(2);
        js.executeScript("arguments[0].style.border='3px solid blue'", buttonCloseWelcomeDialog);
        sleep(2);
        buttonCloseWelcomeDialog.click();
        sleep(1);

        //Cuon chuot den vi tri Bottom cua phan tu
        js.executeScript("arguments[0].scrollIntoView(false);", buttonViewAllCategories);
        sleep(1);
        js.executeScript("arguments[0].style.border='3px solid blue'", buttonViewAllCategories);
        sleep(2);
        buttonViewAllCategories.click();


    }
}

