package br.com.rsinet.appium.tdd.utilitarios;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Acoes {

	private TouchAction touch;
	private AndroidDriver<WebElement> driver;

	public Acoes(AndroidDriver<WebElement> driver) {

		this.driver = driver;
		this.touch = new TouchAction(this.driver);
	}

	public void scrollPais() {

		touch.press(PointOption.point(1055, 1395)).moveTo(PointOption.point(1051, 416)).release().perform();
	}

	public void scrollRegistro() {
		
		touch.press(PointOption.point(1017, 1752)).moveTo(PointOption.point(1055, 748)).release().perform();
	}

}
