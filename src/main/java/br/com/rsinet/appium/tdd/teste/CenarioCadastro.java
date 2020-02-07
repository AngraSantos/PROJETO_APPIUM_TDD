package br.com.rsinet.appium.tdd.teste;

import static br.com.rsinet.appium.tdd.driver.DriverAplicacaoAdvantage.FechandoJanela;
import static br.com.rsinet.appium.tdd.driver.DriverAplicacaoAdvantage.iniciarDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.tdd.ScreenFactory.ScreenCadastro;
import br.com.rsinet.appium.tdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.tdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.tdd.excel.MassaDeDados;
import br.com.rsinet.appium.tdd.report.reports;
import br.com.rsinet.appium.tdd.utilitarios.Acoes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CenarioCadastro {

	private AndroidDriver<MobileElement> driver;
	private ScreenCadastro cadastro;
	private ScreenHome telaInicial;
	private ScreenLogin novaConta;
	private Acoes acao;
	private WebDriverWait wait;
	private MassaDeDados massa;
	private ExtentTest test;

	@BeforeTest
	public void report () {
		
		reports.Report();
	}
	
	@BeforeMethod
	public void inicio() throws MalformedURLException, InterruptedException {

		driver = iniciarDriver();
		telaInicial = new ScreenHome(driver);
		cadastro = new ScreenCadastro(driver);
		novaConta = new ScreenLogin(driver);
		acao = new Acoes(driver);
		massa = new MassaDeDados();
		wait = new WebDriverWait(driver, 10);

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
		
		test = reports.createTest("Cadastrar Usuario");
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
		
		
		assertTrue(driver.getPageSource().contains("Use up to 10 characters"));
		
		test = reports.createTest("Cadastrar Usuario com Falha");
	
	}

	@AfterMethod
	public void finalizar(ITestResult result) throws IOException {

		reports.statusReport (test, result, driver);
		
		driver = FechandoJanela();
		
	}

	@AfterTest
	public void finalizandoReport () {
		
		reports.quitExtent();
	}
}
