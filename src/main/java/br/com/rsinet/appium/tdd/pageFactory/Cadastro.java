package br.com.rsinet.appium.tdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.windows.PressesKeyCode;

public class Cadastro {

	private WebDriverWait wait;
	private WebDriver driver;
	private TouchAction<?> Touch;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
	private WebElement txtbx_username;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
	private WebElement txtbx_Email;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
	private WebElement txtbx_Senha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
	private WebElement txtbx_ConfirmeSenha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
	private WebElement txtbx_Nome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
	private WebElement txtbx_UltimoNome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
	private WebElement txtbx_Telefone;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/textViewCountries']/child::*[1]")
	private WebElement select_Pais;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement txtbx_Estado;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement txtbx_Endereco;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	public WebElement txtbx_Cidade;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement txtbx_CartaoPostal;

	public void Scroll (AndroidDriver driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))").click();
	}

	public Cadastro(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		this.Touch = new TouchAction((PerformsTouchActions) this.driver);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void usuario() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_username)).click();
		txtbx_username.sendKeys("AngraSantos");
	}

	public void email() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Email)).click();
		txtbx_Email.sendKeys("angra.santos@hotmail.com.br");
	}

	public void senha() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Senha)).click();
		txtbx_Senha.sendKeys("Angra123");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void confirmeSenha() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_ConfirmeSenha)).click();
		txtbx_ConfirmeSenha.sendKeys("Angra123");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void primeiroNome() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Nome)).click();
		txtbx_Nome.sendKeys("Angra");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void ultimoNome() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_UltimoNome)).click();
		txtbx_UltimoNome.sendKeys("Santos");

	}

	public void telefone() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Telefone)).click();
		txtbx_Telefone.sendKeys("(11)97051-0060");
	}

	public void pais() throws Exception {
		Select select = new Select(select_Pais);
		select.selectByVisibleText("Brazil");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void cidade() throws Exception {
		txtbx_Cidade.sendKeys("São Paulo");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void endereco() throws Exception {
		txtbx_Endereco.sendKeys("Rua Tres Marias");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void estado() throws Exception {
		txtbx_Estado.sendKeys("São Paulo");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void cartaoPostal() throws Exception {
		txtbx_CartaoPostal.sendKeys("01010-000");
//		Touch.tap(PointOption.point(995, 1698)).perform();
	}
}
