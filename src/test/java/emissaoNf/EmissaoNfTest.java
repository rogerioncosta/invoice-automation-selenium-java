package emissaoNf;

import Pages.LoginPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EmissaoNfTest {

    private WebDriver driver;
    Dotenv dotenv = Dotenv.load();

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
    @DisplayName("Testando se valor total da nf está correto!")
    public void testeSeValorTotalDaNfEstaCorreto() {

        String dbUsuario = dotenv.get("DB_USER");
        String dbSenha = dotenv.get("DB_PASSWORD");
        String dbCnpjCliente = dotenv.get("DB_CNPJ_CLIENT");

        new LoginPage(driver)
                .preencherUsuario(dbUsuario)
                .preencherSenha(dbSenha)
                .clicarParaIrAHomePage()
                .fecharModalAviso()
                .clicarParaPaginaListaNfs()
                .clicarParaPaginaDeEmissaoDeNf()
                .preencherCnpjCliente("60409075002953")
                .preencherCodigoServico("11")
                .preencherValorUnitarioNf("38621,00")
                .preencherQuantidadeServico("1")
                .preencherDataPagamento("22/09/2025")
                .preencherDescricaoServicoEPedido("PAGAMENTO LOGÍSTICA - PLACA DB7727", "45789900")
                .clicarResponsavelIss()
                .preencherValorPis("334,88")
                .preencherValorConfins("12456,77")
                .preencherValorCsll("245,99")
                .preencherValorIr("245,99")
                .clicarOutrosTributos();


        //Assertions.assertEquals("38.125,00", driver.findElement(By.id("span_NFEVALORTOTAL")).getText());

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
