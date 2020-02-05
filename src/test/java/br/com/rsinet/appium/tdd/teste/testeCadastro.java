package br.com.rsinet.appium.tdd.teste;

import static br.com.rsinet.appium.tdd.driver.IniciarAplicacaoAdvantage.iniciarDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.appium.tdd.driver.IniciarAplicacaoAdvantage;
import br.com.rsinet.appium.tdd.excel.MassaDeDados;
import br.com.rsinet.appium.tdd.pageFactory.Cadastro;
import br.com.rsinet.appium.tdd.pageFactory.CriarConta;
import br.com.rsinet.appium.tdd.pageFactory.Home;
import br.com.rsinet.appium.tdd.utilitarios.Acoes;
import io.appium.java_client.android.AndroidDriver;

public class testeCadastro {

	private AndroidDriver<WebElement> driver;
	private Cadastro cadastro;
	private Home telaInicial;
	private CriarConta novaConta;
	private Acoes acao;
	private WebDriverWait wait;
	private MassaDeDados massa;

//	private ExtentTest test;

	@BeforeMethod
	public void inicio() throws MalformedURLException, InterruptedException {

		driver = IniciarAplicacaoAdvantage.iniciarDriver();
		telaInicial = new Home(driver);
		cadastro = new Cadastro(driver);
		novaConta = new CriarConta(driver);
		acao = new Acoes(driver);
		massa = new MassaDeDados();
		
		wait = new WebDriverWait(driver, 10);

//		report.Report();

	}

	@Test
	public void deveFazerUmteste0() throws Exception {

		telaInicial.clicarMenu();

		novaConta.clicarLogin();
		novaConta.criarContaNova();

		cadastro.usuario(massa.usuario());
		cadastro.email(massa.email());
		cadastro.senha(massa.senha());
		cadastro.confirmeSenha(massa.confirmeSenha());

		cadastro.primeiroNome(massa.primeiroNome());
		cadastro.ultimoNome(massa.ultimoNome());
		cadastro.telefone(massa.telefone());

		acao.scroll();

		cadastro.pais(driver, "Brazil");
		cadastro.estado(massa.estado());
		cadastro.endereco(massa.endereco());
		cadastro.cidade(massa.cidade());
		cadastro.cartaoPostal(massa.cartaoPostal());

		cadastro.Registrar();

		telaInicial.clicarMenu();

		WebElement element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), massa.usuario());
	}

	@Test
	public void deveFazerUmteste1() throws Exception {

		telaInicial.clicarMenu();

		novaConta.clicarLogin();
		novaConta.criarContaNova();

		cadastro.usuario(massa.usuario());
		cadastro.email(massa.email());
		cadastro.senha(massa.senha());
		cadastro.confirmeSenha(massa.confirmeSenha());

		cadastro.primeiroNome(massa.primeiroNome());
		cadastro.ultimoNome(massa.ultimoNome());
		cadastro.telefone(massa.telefone());

		acao.scroll();

		cadastro.pais(driver, "Brazil");
		cadastro.estado(massa.estadoInvalido());
		cadastro.endereco(massa.endereco());
		cadastro.cidade(massa.cidade());
		cadastro.cartaoPostal(massa.cartaoPostal());

		cadastro.Registrar();
		
		assertTrue(driver.getPageSource().contains("Use up to 10 characters"));
	}

	@AfterMethod
	public void finalizar() {

		driver = IniciarAplicacaoAdvantage.FechandoJanela();
		
//		report.statusReported(test, result, driver);
		
		 
	}
//
//	@AfterTest
//	public void finalizar2() {
//
//		report.quitExtent();
//	}

}
