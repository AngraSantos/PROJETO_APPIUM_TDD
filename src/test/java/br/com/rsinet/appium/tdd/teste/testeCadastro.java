package br.com.rsinet.appium.tdd.teste;


import static br.com.rsinet.appium.tdd.driver.IniciarAplicacaoAdvantage.iniciarDriver;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.com.rsinet.appium.tdd.pageFactory.Cadastro;
import br.com.rsinet.appium.tdd.pageFactory.CriarConta;
import br.com.rsinet.appium.tdd.pageFactory.Home;
import io.appium.java_client.android.AndroidDriver;

public class testeCadastro {

//	private AndroidDriver<MobileElement> driver;
	private AndroidDriver<WebElement> driver;
	private Cadastro cadastro;
	private Home telaInicial;
	private CriarConta novaConta;
	

	@Before
	public void inicio() throws MalformedURLException, InterruptedException {

		driver = iniciarDriver();
		telaInicial = new Home(driver);
		cadastro = new Cadastro(driver);
		novaConta = new CriarConta(driver);
	}

	@Test
	public void deveFazerUmtesteComSucesso() throws Exception {

		telaInicial.clicarMenu();
		novaConta.clicarLogin();
		novaConta.criarContaNova();

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

		Thread.sleep(3000);
		driver.quit();
	}

}
