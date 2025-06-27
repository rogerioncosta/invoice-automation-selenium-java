package emissaoNf;

import Pages.LoginPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmissaoNfTest {

    private WebDriver driver;
    Dotenv dotenv = Dotenv.load();
    WebDriverWait wait;

    String dbUsuario = dotenv.get("DB_USER");
    String dbSenha = dotenv.get("DB_PASSWORD");
    String dbCnpjCliente = dotenv.get("DB_CNPJ_CLIENT");

    @BeforeAll
    public void before() {
        // Abrir o navegador
        this.driver = new EdgeDriver();

        // Maximizar o navegador
        this.driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String dbUrl = dotenv.get("DB_URL");
        // Navegar até a página web
        this.driver.get(dbUrl);
    }

    public void preenchimentoDosDadosDaNf() {

        new LoginPage(driver)
                .preencherUsuario(this.dbUsuario)
                .preencherSenha(this.dbSenha)
                .clicarParaIrAHomePage()
                .fecharModalAviso()
                .clicarParaPaginaListaNfs()
                .clicarParaPaginaDeEmissaoDeNf()
                .preencherCnpjCliente(this.dbCnpjCliente)
                .preencherCodigoServico("11")
                .preencherValorUnitarioNf("38125,00")
                .preencherQuantidadeServico("1")
                .preencherDataPagamento("22/09/2025")
                .preencherDescricaoServicoEPedido("PAGAMENTO LOGÍSTICA - PLACA DB7727", "45789900")
                .clicarResponsavelIss()
                .preencherValorPis("247,81")
                .preencherValorConfins("1143,75")
                .preencherValorCsll("381,25")
                .preencherValorIr("381,25")
                .clicarOutrosTributos();
    }

    @Test
    @DisplayName("Validar o valor total da Nota fiscal!")
    public void testeDeValidacaoDoValorTotalDaNf() {

        // preenchimentoDosDadosDaNf();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#span_NFEVALORTOTAL")));
        Assertions.assertEquals("38.125,00", driver.findElement(By.id("span_NFEVALORTOTAL")).getText());

    }

    @Test
    @DisplayName("Validar o valor líquido da Nota fiscal!")
    public void testeDeValidacaoDoValorLiquidoDaNf() {
        // Chama a massa de testes para preencher os dados, pois esse teste está sendo executado primeiro
        preenchimentoDosDadosDaNf();

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#span__NFEVALORLIQUIDONOTA")));
        Assertions.assertEquals("35.970,94", driver.findElement(By.id("span__NFEVALORLIQUIDONOTA")).getText());

    }

    @Test
    @DisplayName("Validar os valores dos impostos a pagar na Nota fiscal!")
    public void testeDeValidacaoDosValoresDosImpostos() {

        // preenchimentoDosDadosDaNf();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#span__OUTROSIMPOSTOS")));
        Assertions.assertEquals("2.154,06", driver.findElement(By.id("span__OUTROSIMPOSTOS")).getText());

    }
/*
    @AfterEach
    public void afterEach() {
        driver.quit();
    }
 */
}
