package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage fecharModalAviso() {
        // Ir para a Home
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Home"));
        WebElement msgAlvara = driver.findElement(By.className("fecharModal"));
        wait.until(ExpectedConditions.elementToBeClickable(msgAlvara));
        msgAlvara.click();

        return this;
    }

    public ListaNfsPage clicarParaPaginaListaNfs() {
        // Ir para a página de listagem de nfs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement elementMenuNf = driver.findElement(By.xpath("//a[contains(@class, 'dir') and contains(text(), 'Nota fiscal')]"));
        wait.until(ExpectedConditions.elementToBeClickable(elementMenuNf));
        elementMenuNf.click();

        driver.findElement(By.xpath("//a[contains(text(), 'Nota Fiscal Eletrônica')]")).click();

        return new ListaNfsPage(driver);
    }

}
