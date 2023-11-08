package tests.sanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SanityScenario {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";
       driver.get(baseUrl);

       String actualUrl = driver.getCurrentUrl();

      Assert.assertEquals(actualUrl, baseUrl);


        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
       driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
       driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();


       String productsPageUrl = "https://www.saucedemo.com/inventory.html";
       actualUrl = driver.getCurrentUrl();


           Assert.assertEquals(productsPageUrl, actualUrl);


           String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
           String expectedTitle = "Products";


            Assert.assertEquals(title, expectedTitle);


        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-onesie']")).click();

        WebElement shoppingCartBadge = driver.findElement(By.cssSelector("[class='shopping_cart_badge']"));

         /*  Optional validation
        String actualNumberOfItems = shoppingCartBadge.getText();
        String expectedNumberOfItems = "2";
   */


        int actualNumberOfItems = Integer.parseInt(shoppingCartBadge.getText());
        int expectedNumberOfItems = 2;

           Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems, "Number of Items is different.");

           shoppingCartBadge.click();


        driver.close();
        driver.quit();
















    }

}
