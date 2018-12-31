package myPackage;

import org.testng.annotations.*;
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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void Driver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			File file = new File("C:/geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			File file = new File("C:/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			File file = new File("C:/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Not found");
		}
	}

	@AfterTest
	public void end() {
		driver.quit();
	}

	@Test
	public void f() throws Exception {

		String url = "http://localhost:1572/";
		driver.get(url);

		Login login = new Login(driver);

		/*
		 * NOW WE WILL LOGIN INVALID USERS
		 */

		Scanner scan = new Scanner(new File("login_invalid.txt"));

		while (scan.hasNextLine()) {
			String id = scan.nextLine();
			String pass = scan.nextLine();

			login.loginuser(id, pass);
			Assert.assertEquals(driver.getTitle(), "Sign in");
		}

		scan.close();

		/*
		 * NOW WE WILL LOGIN VALID USERS
		 */

		scan = new Scanner(new File("login_valid.txt"));

		while (scan.hasNextLine()) {
			String id = scan.nextLine();
			String pass = scan.nextLine();

			login.loginuser(id, pass);
			Assert.assertEquals(driver.getTitle(), "Admin");
			driver.findElement(By.partialLinkText("Logout")).click();
		}

		scan.close();
	}
}
