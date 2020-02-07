package br.com.rsinet.appium.tdd.teste;

import static br.com.rsinet.appium.tdd.driver.DriverAplicacaoAdvantage.FechandoJanela;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

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
import br.com.rsinet.appium.tdd.ScreenFactory.ScreenProduto;
import br.com.rsinet.appium.tdd.driver.DriverAplicacaoAdvantage;
import br.com.rsinet.appium.tdd.report.reports;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CenarioBuscarLupa {

	private AndroidDriver<MobileElement> driver;
	private ScreenProduto produtos;
	private ScreenHome telaInicial;
	private WebDriverWait wait;
	private ExtentTest test;
	
	@BeforeTest
	public void report () {
		
		reports.Report();
	}

	@BeforeMethod
	public void inicio() throws Exception {

		driver = DriverAplicacaoAdvantage.iniciarDriver();
		produtos = new ScreenProduto(driver);
		telaInicial = new ScreenHome(driver);
		wait = new WebDriverWait(driver, 20);

	}

	@Test
	public void deveBuscarProduto0() {

		telaInicial.buscarLupa("mouse");
		produtos.mouseHPz4000();

		assertTrue(driver.getPageSource().contains("HP Z4000 WIRELESS MOUSE"));
		
		test = reports.createTest("Buscando produto pela lupa");

	}
	

	@Test	
	public void deveBuscarProduto1 () {
		
		telaInicial.buscarLupa("fone");
	
		WebElement NaoEncontrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow"));
		wait.until(ExpectedConditions.visibilityOf(NaoEncontrado));
		assertEquals(NaoEncontrado.getText(),"- No results for \"fone\" -");
		
		test = reports.createTest("Buscando produto pela lupa indisponivel");
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
