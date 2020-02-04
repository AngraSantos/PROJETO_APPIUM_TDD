package br.com.rsinet.appium.tdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Cadastro {

	private WebDriverWait wait;
	private WebDriver driver;

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

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewCountries")
	private WebElement select_Pais;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement txtbx_Estado;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement txtbx_Endereco;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	public WebElement txtbx_Cidade;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement txtbx_CartaoPostal;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement btn_Registrar;

	public Cadastro(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void usuario() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_username)).click();
		txtbx_username.sendKeys("AngraSan");
	}

	public void email() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Email)).click();
		txtbx_Email.sendKeys("angra.santos@hotmail.com.br");
	}

	public void senha() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Senha)).click();
		txtbx_Senha.sendKeys("Angra123");

	}

	public void confirmeSenha() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_ConfirmeSenha)).click();
		txtbx_ConfirmeSenha.sendKeys("Angra123");
	}

	public void primeiroNome() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Nome)).click();
		txtbx_Nome.sendKeys("Angra");
	}

	public void ultimoNome() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_UltimoNome)).click();
		txtbx_UltimoNome.sendKeys("Santos");
	}

	public void telefone() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Telefone)).click();
		txtbx_Telefone.sendKeys("(11)97051-0060");
	}

	public void pais(AndroidDriver<WebElement> driver) {

		wait.until(ExpectedConditions.visibilityOf(select_Pais)).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Brazil" + "\").instance(0))")
				.click();
	}

	public void cidade() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Cidade)).click();
		txtbx_Cidade.sendKeys("São Paulo");
	}

	public void endereco() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Endereco)).click();
		txtbx_Endereco.sendKeys("Rua Tres Marias");
	}

	public void estado() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Estado)).click();
		txtbx_Estado.sendKeys("São Paulo");
	}

	public void cartaoPostal() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_CartaoPostal)).click();
		txtbx_CartaoPostal.sendKeys("01010-000");
	}
	public void Registrar() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(btn_Registrar));
		btn_Registrar.click();
	}
}
