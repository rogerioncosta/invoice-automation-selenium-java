package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage preencherUsuario(String usuario) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Acesso ao Sistema"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("_USUARIOLOGINLOGIN")));

        // Fazer o login
        driver.findElement(By.id("_USUARIOLOGINLOGIN")).click();
        driver.findElement(By.id("_USUARIOLOGINLOGIN")).sendKeys(usuario);
        driver.findElement(By.id("IMAGE2")).click();

        return this;
    }

    public LoginPage preencherSenha(String senha) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("_USUARIOLOGINSENHA")));
        driver.findElement(By.id("_USUARIOLOGINSENHA")).click();
        driver.findElement(By.id("_USUARIOLOGINSENHA")).sendKeys("502transzape");

        return this;
    }

    public HomePage clicarParaIrAHomePage(){
        driver.findElement(By.id("BTN_ENTER")).click();

        return new HomePage(driver);
    }
}
