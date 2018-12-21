package myPackage;

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

public class Login {
	WebDriver driver = null;
	Login() throws InterruptedException {
		File file = new File("C:/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";
		
		driver = new EdgeDriver();
		driver.get(url);
		Thread.sleep(2000);
		System.out.println("1");
		driver.findElement(By.cssSelector("#signin1")).click();
		
		System.out.println("2");
		Thread.sleep(2000);
	}
	void loginuser(String name, String pass) throws InterruptedException {	
		driver.findElement(By.cssSelector("#email")).sendKeys(name);
		driver.findElement(By.cssSelector("#pass")).sendKeys(pass);
		
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}
	public static void main(String []args) throws InterruptedException {
		Login l = new Login();
		l.loginuser("admin@gmail.com", "12345");
	}
}
