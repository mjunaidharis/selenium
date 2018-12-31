package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void Driver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			File file = new File("C:/geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette",file.getAbsolutePath());
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			File file = new File("C:/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("IE")) {
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
	public void f() throws InterruptedException, FileNotFoundException {

		String url = "http://localhost:1572/";
		driver.get(url);
		Thread.sleep(2000);

		Search search = new Search(driver);
		Thread.sleep(2000);
		/*
		 * SEARCH ALL THE MOVIES THAT DOES NOT EXIST
		 */
		Scanner scan = new Scanner(new File("movies_invalid.txt"));
		while (scan.hasNextLine()) {
			String movie = scan.nextLine();
			search.searchMovie(movie);
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.id("notfound")).getText().contains("NOT"));
			// Assert.assertTrue(driver.findElement(By.id("#notfound")) != null);
		}
		scan.close();

		/*
		 * NOW WE WILL Search valid USERS
		 */
		scan = new Scanner(new File("movies_valid.txt"));
		while (scan.hasNextLine()) {
			String movie = scan.nextLine();

			search.searchMovie(movie);
			Thread.sleep(1000);
			Assert.assertFalse(driver.findElement(By.id("notfound")).getText().contains("NOT"));
		}
		scan.close();
	}
}
