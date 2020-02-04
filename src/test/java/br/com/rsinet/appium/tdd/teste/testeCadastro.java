package br.com.rsinet.appium.tdd.teste;


import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.com.rsinet.appium.tdd.driver.IniciarAplicacaoAdvantage;
import br.com.rsinet.appium.tdd.pageFactory.Cadastro;
import br.com.rsinet.appium.tdd.pageFactory.telaInicial;
import io.appium.java_client.android.AndroidDriver;

public class testeCadastro {

//	private AndroidDriver<MobileElement> driver;
	private AndroidDriver<WebElement> driver;
	private Cadastro cadastro;
	private telaInicial telainicial;
	

	@Before
	public void inicio() throws MalformedURLException, InterruptedException {

		driver = IniciarAplicacaoAdvantage.iniciarDriver();
		
		telainicial = new telaInicial(driver);
		cadastro = new Cadastro(driver);
	}

	@Test
	public void BuscandoTeste() throws Exception {

		telainicial.clicarMenu();
		telainicial.clicarLogin();
		telainicial.criarConta();

 		cadastro.usuario();
		cadastro.email();
		cadastro.senha();
		cadastro.confirmeSenha();
		
		cadastro.primeiroNome();
		cadastro.ultimoNome();
		cadastro.telefone();
		
//		cadastro.pais();
//		cadastro.estado();
//		cadastro.endereco();
//		cadastro.cidade();
//		cadastro.cartaoPostal();
		
		

	}

	@After
	public void finalizar() throws Exception {

		Thread.sleep(10000);
		driver.quit();
	}

}
