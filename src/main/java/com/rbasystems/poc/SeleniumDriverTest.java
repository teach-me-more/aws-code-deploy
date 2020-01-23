package com.rbasystems.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriverTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/amar_deep_singh/git/aws-code-deploy/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement email = driver.findElement(By.name("session_key"));
        WebElement passw = driver.findElement(By.name("session_password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));
        email.sendKeys("nidhisingh51@gmail.com");
        passw.sendKeys("Chaudhary@1");
        loginButton.submit();
	}

}
