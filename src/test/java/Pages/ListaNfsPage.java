package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaNfsPage {
    private WebDriver driver;

    public ListaNfsPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmissaoNfPage clicarParaPaginaDeEmissaoDeNf() {
        Assertions.assertEquals("Manutenção Nota Fiscal Eletrônica", driver.getTitle());

        // Ir para a página de emissão da nf
        driver.findElement(By.id("_IMGINSERIR")).click();

        return new EmissaoNfPage(driver);
    }
}
