package br.com.rsinet.appium.tdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class telaInicial {

	private WebDriverWait wait;
	private AndroidDriver<WebElement> driver;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement txtbx_menu;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutLogin")
	private WebElement txtbx_login;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement txtbx_criarConta;

	public telaInicial(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
//		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void clicarMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_menu));
		txtbx_menu.click();
	}

	public void clicarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_login));
		txtbx_login.click();
	}

	public void criarConta() {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_criarConta));
		txtbx_criarConta.click();
	}

}