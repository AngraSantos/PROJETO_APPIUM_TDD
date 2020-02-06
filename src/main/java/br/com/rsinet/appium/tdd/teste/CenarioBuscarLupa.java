package br.com.rsinet.appium.tdd.teste;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.appium.tdd.pageFactory.Produto;
import io.appium.java_client.android.AndroidDriver;

public class CenarioBuscarLupa {
	
	private AndroidDriver<WebElement> driver;
	private Produto produtos ;
	
	@BeforeMethod 
	public void inicio() {
		
		
		
	}

	@Test
	public void deveBuscarProduto () {
		
	}

	@AfterMethod
	public void finalizar() {
		
	}

}

