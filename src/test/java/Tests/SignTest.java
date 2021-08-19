package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SignTest {

    private WebDriver navegador;

    @BeforeClass
    public static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();



    }

    @Before
    public void setupTest() {


        //navegador = new ChromeDriver();
        navegador = new FirefoxDriver();

        navegador.get("https://seubarriga.wcaquino.me/");
        WebElement emailInput = navegador.findElement(By.id("email"));
        emailInput.sendKeys("tamara@teste.com");
        WebElement senhaInput = navegador.findElement(By.id("senha"));
        senhaInput.sendKeys("123456");
        WebElement entrarbotao = navegador.findElement(By.className("btn-primary"));
        entrarbotao.click();

        WebElement mensagemSucesso = navegador.findElement(By.className("alert-success"));


    }

    /*@After
    public void teardown() {
        if (navegador != null) {
            navegador.quit();
        }
    }*/

   /* @Test
    public void testFazerLoginSiteSeuBarriga() {




        WebElement entrarbotao = navegador.findElement(By.className("btn-primary"));
        entrarbotao.click();

        WebElement mensagemSucesso = navegador.findElement(By.className("alert-success"));
        mensagemSucesso.getText();

    }*/

    @Test
    public void testValidandoMensagemInformeNomeDaConta() {




        WebElement addConta = navegador.findElement(By.className("dropdown-toggle"));
        addConta.click();

        WebElement adicionar = navegador.findElement(By.linkText("Adicionar"));
        adicionar.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();

        WebElement mensagemErro = navegador.findElement(By.className("alert-danger"));

        assertEquals("Informe o nome da conta", navegador.findElement(By.className("alert-danger")).getText());
        //navegador.quit();

    }

    @Test
    public void testMensagemContaCriadaComSucesso() {

        //navegador.get("https://seubarriga.wcaquino.me/");




        WebElement addConta = navegador.findElement(By.className("dropdown-toggle"));
        addConta.click();

        WebElement adicionar = navegador.findElement(By.linkText("Adicionar"));
        adicionar.click();

        WebElement nome = navegador.findElement(By.id("nome"));
        nome.sendKeys("Vinicius Teste ");
        WebElement botao = navegador.findElement(By.className("btn-primary"));
        botao.click();

       // WebElement message = navegador.findElement(By.className("alert-success"));

        assertEquals("Conta adicionada com sucesso!", navegador.findElement(By.className("alert-success")).getText());


    }

    @Test

    public void testApresentarContasListar() {




        WebElement contaBotao = navegador.findElement(By.className("dropdown-toggle"));
        contaBotao.click();

        WebElement listaropcao = navegador.findElement(By.linkText("Listar"));
        listaropcao.click();


    }

    @Test
    public void testAlteracaoDeConta() {

        WebElement contaBotao = navegador.findElement(By.className("dropdown-toggle"));
        contaBotao.click();

        WebElement listaropcao = navegador.findElement(By.linkText("Listar"));
        listaropcao.click();

        WebElement tabela = navegador.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']"));
        tabela.click();
        WebElement nomeAlterar = navegador.findElement(By.className("form-control"));
        nomeAlterar.sendKeys("NomeAlterado");
        WebElement botaoSalvar = navegador.findElement(By.className("btn-primary"));
        botaoSalvar.click();

        assertEquals("Conta alterada com sucesso!",navegador.findElement(By.className("alert-success")).getText());


    }

    @Test
    public void testMensagemContaRemovidaComSucesso(){

        WebElement contaBotao = navegador.findElement(By.className("dropdown-toggle"));
        contaBotao.click();

        WebElement listaropcao = navegador.findElement(By.linkText("Listar"));
        listaropcao.click();

        WebElement tabela = navegador.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']"));
        tabela.click();

        assertEquals("Conta removida com sucesso!",navegador.findElement(By.className("alert-success")).getText());

    }

    @Test

    public void testeMovimentacaoMensagemCamposObrigatorios(){

        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();

    }

    @Test
    public void testeMensagemSucessoMovimentacao(){

        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement tipoopcao = navegador.findElement(By.id("tipo"));
        Select tipo = new Select(tipoopcao);
        tipo.selectByValue("REC");

        WebElement dataInput = navegador.findElement(By.id("data_transacao"));
        dataInput.sendKeys("10/09/2020");

        WebElement dataPagamentoinput= navegador.findElement(By.id("data_pagamento"));
        dataPagamentoinput.sendKeys("11/09/2020");

        WebElement descricaoinput= navegador.findElement(By.id("descricao"));
        descricaoinput.sendKeys("Quitar");

        WebElement interessadoinput= navegador.findElement(By.id("interessado"));
        interessadoinput.sendKeys("Manuela Teste");

        WebElement valorInput = navegador.findElement(By.id("valor"));
        valorInput.sendKeys("%&*#2");

        WebElement comboI = navegador.findElement(By.id("conta"));
        Select contaI = new Select(comboI);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();

        Assert.assertEquals("Valor deve ser um número",navegador.findElement(By.className("alert-danger")).getText());

    }

    @Test
    public void testeMensagemMovimentacaoCriadaComSucesso(){
        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement tipoopcao = navegador.findElement(By.id("tipo"));
        Select tipo = new Select(tipoopcao);
        tipo.selectByValue("REC");

        WebElement dataInput = navegador.findElement(By.id("data_transacao"));
        dataInput.sendKeys("10/09/2020");

        WebElement dataPagamentoinput= navegador.findElement(By.id("data_pagamento"));
        dataPagamentoinput.sendKeys("11/09/2020");

        WebElement descricaoinput= navegador.findElement(By.id("descricao"));
        descricaoinput.sendKeys("Quitar");

        WebElement interessadoinput= navegador.findElement(By.id("interessado"));
        interessadoinput.sendKeys("Teste");

        WebElement valorInput = navegador.findElement(By.id("valor"));
        valorInput.sendKeys("1000.00");

        WebElement comboI = navegador.findElement(By.id("conta"));
        Select contaI = new Select(comboI);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();

        Assert.assertEquals("Movimentação adicionada com sucesso!",navegador.findElement(By.className("alert-success")).getText());
    }
    @Test
    public void test(){

        WebElement resumomensal = navegador.findElement(By.xpath("//*[@id='tabelaSaldo']/thread/tr/th[1]"));




    }

}
