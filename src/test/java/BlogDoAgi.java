import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BlogDoAgi {
    @Test
    public void pesquisa(){
        String termoPesquisa ="suas finanças";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://blogdoagi.com.br/");
        WebElement searchButton = driver.findElement(By.cssSelector("button[id=search-open]"));
        searchButton.click();
        WebElement campoPesquisa= driver.findElement(By.cssSelector("div.desktop-search form input[class=search-field]"));
        campoPesquisa.sendKeys(termoPesquisa);
        WebElement btnPesquisar= driver.findElement(By.cssSelector("div.desktop-search form input[value=Pesquisar]"));
        btnPesquisar.click();
        WebElement resultadoPesquisa= driver.findElement(By.xpath("//h1//span[contains(text(),'suas finanças')]"));
        Assert.assertEquals(resultadoPesquisa.getText(),termoPesquisa);
        driver.quit();
    }
}
