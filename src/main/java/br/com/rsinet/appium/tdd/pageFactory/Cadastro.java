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

public class Cadastro {
	
	private WebDriverWait wait;
	private WebDriver driver;
	private TouchAction Touch;

	@FindBy(how = How.XPATH, using = "//*")
	private WebElement txtbx_username;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txtbx_Email;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText\r\n" + 
			"")
	private WebElement txtbx_Senha;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txtbx_ConfirmeSenha;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement txtbx_Nome;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText\r\n"
			+ "")
	private WebElement txtbx_UltimoNome;

	@FindBy(how = How.NAME, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txtbx_Telefone;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout\r\n"
			+ "")
	private WebElement select_Pais;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText\r\n"
			+ "")
	public WebElement txtbx_Cidade;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txtbx_Endereco;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText\r\n"
			+ "")
	private WebElement txtbx_Estado;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement txtbx_CartaoPostal;

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
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void confirmeSenha() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_ConfirmeSenha)).click();
		txtbx_ConfirmeSenha.sendKeys("Angra123");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void primeiroNome() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Nome)).click();
		txtbx_Nome.sendKeys("Angra");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void ultimoNome() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_UltimoNome)).click();
		txtbx_UltimoNome.sendKeys("Santos");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void telefone() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Telefone)).click();
		txtbx_Telefone.sendKeys("(11)97051-0060");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void pais() throws Exception {
		Select select = new Select(select_Pais);
		select.selectByVisibleText("Brazil");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void cidade() throws Exception {
		txtbx_Cidade.sendKeys("São Paulo");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void endereco() throws Exception {
		txtbx_Endereco.sendKeys("Rua Tres Marias");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void estado() throws Exception {
		txtbx_Estado.sendKeys("São Paulo");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}

	public void cartaoPostal() throws Exception {
		txtbx_CartaoPostal.sendKeys("01010-000");
		Touch.tap(PointOption.point(995, 1698)).perform();
	}
}
