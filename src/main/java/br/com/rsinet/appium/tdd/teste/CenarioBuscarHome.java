package br.com.rsinet.appium.tdd.teste;

import static br.com.rsinet.appium.tdd.driver.IniciarAplicacaoAdvantage.FechandoJanela;
import static br.com.rsinet.appium.tdd.driver.IniciarAplicacaoAdvantage.iniciarDriver;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.appium.tdd.excel.MassaDeDados;
import br.com.rsinet.appium.tdd.pageFactory.Cadastro;
import br.com.rsinet.appium.tdd.pageFactory.Home;
import br.com.rsinet.appium.tdd.pageFactory.Login;
import br.com.rsinet.appium.tdd.pageFactory.Produto;
import br.com.rsinet.appium.tdd.utilitarios.Acoes;
import io.appium.java_client.android.AndroidDriver;

public class CenarioBuscarHome {

	private AndroidDriver<WebElement> driver;
	private Home telaInicial;
	private Produto produtos;
	private WebDriverWait wait;
	private Login telaLogin;
	private MassaDeDados massa;
	private Acoes acao;

	@BeforeMethod
	public void inicio() throws MalformedURLException, InterruptedException {

		driver = iniciarDriver();
		telaInicial = new Home(driver);
		produtos = new Produto(driver);
		massa = new MassaDeDados();
		telaLogin = new Login(driver);
		acao = new Acoes(driver);
		wait = new WebDriverWait(driver, 20);

	}

	@Test
	public void deveBuscarProduto0() {

		telaInicial.clicarTablet();

		produtos.tabletEliteX2();

		WebElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "HP ELITE X2 1011 G1 TABLET");

	}
	
	@Test
	public void deveBuscarProduto1() throws Exception {

		telaInicial.clicarMenu();
		
		telaLogin.clicarLogin();
		telaLogin.incluirUsuario(massa.usuario());
		telaLogin.incluirSenha(massa.senha());
		
		telaLogin.apertarBotaoEntrarLogin();
		
		telaInicial.clicarTablet();
		
		produtos.tabletEliteX2();
		produtos.Quatidade();
		produtos.QuatidadeDeProduto("20");
		produtos.confirmarQuantidade();
		produtos.incluirCarrinho();
		produtos.clicarCarrinho();
		
		
//		WebElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		assertEquals(element.getText(), "HP ELITE X2 1011 G1 TABLET");

	}


	@AfterMethod
	public void finalizar() {
//		driver = FechandoJanela();

	}

}
