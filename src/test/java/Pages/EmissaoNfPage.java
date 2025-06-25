package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmissaoNfPage {
    private WebDriver driver;

    public EmissaoNfPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmissaoNfPage preencherCnpjCliente(String cnpjCliente) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // Preencher os dados para emissão da nf
        wait.until(ExpectedConditions.titleIs("Nota Fiscal Eletrônica"));

        driver.findElement(By.id("NFETOMCONCPFCNPJ")).sendKeys(cnpjCliente);

        return this;
    }

    public EmissaoNfPage preencherCodigoServico(String codigoServico) {
        driver.findElement(By.id("SERVCODIGO_0001")).click();
        driver.findElement(By.id("SERVCODIGO_0001")).clear();
        driver.findElement(By.id("SERVCODIGO_0001")).sendKeys(codigoServico);

        return this;
    }

    public EmissaoNfPage preencherValorUnitarioNf(String valorUnitarioNf) {
        driver.findElement(By.id("NFESERVVALORUNIT_0001")).click();
        driver.findElement(By.id("NFESERVVALORUNIT_0001")).clear();
        driver.findElement(By.id("NFESERVVALORUNIT_0001")).sendKeys(valorUnitarioNf);

        return this;
    }

    public EmissaoNfPage preencherQuantidadeServico(String quantidadeServico) {
        driver.findElement(By.id("NFESERVQTDE_0001")).click();
        driver.findElement(By.id("NFESERVQTDE_0001")).clear();
        driver.findElement(By.id("NFESERVQTDE_0001")).sendKeys(quantidadeServico);

        return this;
    }

    public EmissaoNfPage preencherDataPagamento(String dataPagamento) {
        driver.findElement(By.id("NFEDATAVENC")).click();
        driver.findElement(By.id("NFEDATAVENC")).sendKeys(dataPagamento);

        return this;
    }

    public EmissaoNfPage preencherDescricaoServicoEPedido(String descricaoServico, String pedido) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(descricaoServico + "\n\n" + "PEDIDO: " + pedido)
                .perform();

        return this;
    }

    public EmissaoNfPage clicarResponsavelIss() {
        driver.findElement(By.id("NFERETIDO")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'Prestador dos Serviços')]")).click();

        return this;
    }

    public EmissaoNfPage preencherValorPis(String valorPis) {
        driver.findElement(By.id("NFEPIS")).click();
        driver.findElement(By.id("NFEPIS")).sendKeys(valorPis);

        return this;
    }

    public EmissaoNfPage preencherValorConfins(String valorConfins) {
        driver.findElement(By.id("NFECOFINS")).click();
        driver.findElement(By.id("NFECOFINS")).sendKeys(valorConfins);

        return this;
    }

    public EmissaoNfPage preencherValorCsll(String valorCsll) {
        driver.findElement(By.id("NFECSLL")).click();
        driver.findElement(By.id("NFECSLL")).sendKeys(valorCsll);

        return this;
    }

    public EmissaoNfPage preencherValorIr(String valorIr) {
        driver.findElement(By.id("NFEIR")).click();
        driver.findElement(By.id("NFEIR")).sendKeys(valorIr);

        return this;
    }

    public EmissaoNfPage clicarOutrosTributos() {
        driver.findElement(By.id("NFEOUTROSTRIBUTOS")).click();

        return this;
    }




}
