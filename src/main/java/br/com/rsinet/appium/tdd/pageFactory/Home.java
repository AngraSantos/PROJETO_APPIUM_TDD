package br.com.rsinet.appium.tdd.pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Home {

	private WebDriverWait wait;
	private AndroidDriver<MobileElement> driver;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement txtbx_menu;

	public Home(WebDriver driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void clicarMenu() {
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(txtbx_menu));
		txtbx_menu.click();
	}
	
}