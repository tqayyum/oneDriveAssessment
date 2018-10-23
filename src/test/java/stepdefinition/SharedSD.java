package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import util.ConfigReader;

public class SharedSD {

	private static WebDriver driver = null;
	@Before()
	public static void before() {

		ConfigReader configReader = new ConfigReader();
		System.setProperty("webdriver.chrome.driver",
				configReader.getChromeDriverPath());
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configReader.getUrl());
	}

	@After()
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
