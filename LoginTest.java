package myPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {
	@Test
	public void f() throws InterruptedException {
		WebDriver driver;
		File file = new File("C:/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);

		Login login = new Login(driver);
		login.loginuser("admin@gmail.com", "12345");
		System.out.println(driver.getTitle());
	}
}
