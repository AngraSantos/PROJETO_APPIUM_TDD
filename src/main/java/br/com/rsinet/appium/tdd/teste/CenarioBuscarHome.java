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

import br.com.rsinet.appium.tdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.tdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.tdd.ScreenFactory.ScreenProduto;
import br.com.rsinet.appium.tdd.excel.MassaDeDados;
import br.com.rsinet.appium.tdd.report.reports;
import br.com.rsinet.appium.tdd.utilitarios.RolagemTela;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CenarioBuscarHome {

	private AndroidDriver<MobileElement> driver;
	private ScreenHome telaInicial;
	private ScreenProduto produtos;
	private WebDriverWait wait;
	private ScreenLogin telaLogin;
	private MassaDeDados massa;
	private ExtentTest test;
	private RolagemTela rolagem;
	
	@BeforeTest
	public void report () {
		
		reports.Report();
	}

	@BeforeMethod
	public void inicio() throws MalformedURLException, InterruptedException {

		driver = iniciarDriver();
		
		telaInicial = new ScreenHome(driver);
		produtos = new ScreenProduto(driver);
		massa = new MassaDeDados();
		telaLogin = new ScreenLogin(driver);
		rolagem = new RolagemTela(driver);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void deveBuscarProduto0() {

		rolagem.scroll("Mice");
		
		rolagem.scroll("MICROSOFT SCULPT TOUCH MOUSE");
		
		WebElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "MICROSOFT SCULPT TOUCH MOUSE");
		
		test = reports.createTest("Buscando produto pela Home");
	}
	
	@Test
	public void deveBuscarProduto1() throws Exception {

		telaInicial.clicarMenu();
		telaLogin.clicarLogin();
		
		telaLogin.incluirUsuario(massa.usuario());
		telaLogin.incluirSenha(massa.senha());
		telaLogin.apertarBotaoEntrarLogin();
		
		telaInicial.clicarHeadphones();
		
		produtos.FoneLogitech();
		produtos.Quantidade();
		produtos.QuantidadeDeProduto("20");
		produtos.confirmarQuantidade();
		produtos.incluirCarrinho();
		produtos.clicarCarrinho();
		
		assertTrue(driver.getPageSource().contains("10"));
	
		test = reports.createTest("Buscando produto pela Home com Falha");
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
