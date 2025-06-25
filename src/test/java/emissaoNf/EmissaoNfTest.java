package emissaoNf;

import Pages.LoginPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EmissaoNfTest {

    private WebDriver driver;
    Dotenv dotenv = Dotenv.load();

    String dbUsuario = dotenv.get("DB_USER");
    String dbSenha = dotenv.get("DB_PASSWORD");
    String dbCnpjCliente = dotenv.get("DB_CNPJ_CLIENT");

    @BeforeEach
    public void beforeEach() {
        // Abrir o navegador
        this.driver = new EdgeDriver();

        // Maximizar o navegador
        this.driver.manage().window().maximize();

        String dbUrl = dotenv.get("DB_URL");
        // Navegar até a página web
        this.driver.get(dbUrl);
    }

    @Test
    @DisplayName("Validar o valor total da Nota fiscal!")
    public void testeDeValidacaoDoValorTotalDaNf() {

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

        Assertions.assertEquals("38.125,00", driver.findElement(By.id("span_NFEVALORTOTAL")).getText());

    }

    @Test
    @DisplayName("Validar o valor líquido da Nota fiscal!")
    public void testeDeValidacaoDoValorLiquidoDaNf() {

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

        Assertions.assertEquals("35.970,94", driver.findElement(By.id("span__NFEVALORLIQUIDONOTA")).getText());

    }

    @Test
    @DisplayName("Validar os valores dos impostos a pagar na Nota fiscal!")
    public void testeDeValidacaoDosValoresDosImpostos() {

        new LoginPage(this.driver)
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

        Assertions.assertEquals("2.154,06", driver.findElement(By.id("span__OUTROSIMPOSTOS")).getText());

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
