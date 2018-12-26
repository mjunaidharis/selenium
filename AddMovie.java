package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddMovie {
	WebDriver driver = null;

	AddMovie(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void loginuser(String name, String pass) throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.cssSelector("#email")).sendKeys(name);
		driver.findElement(By.cssSelector("#pass")).sendKeys(pass);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}

	boolean gotoAddMoviePage() {
		if (driver.getTitle().equalsIgnoreCase("admin" + "_addmovie")) {
			return true;
		}
		if (!driver.getTitle().contains("Admin")) {
			// not signed in
			return false;
		}
		// click that button of add user
		driver.findElement(By.partialLinkText("Add Movies")).click();
		return true;
	}

	void InsertMovie(String name, String year, String picture, String language, String cast, String rating,
			String trailer, String review) throws InterruptedException {
		if (!gotoAddMoviePage())
			return;
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("year")).sendKeys(year);
		driver.findElement(By.id("picture")).sendKeys(picture);
		driver.findElement(By.id("language")).sendKeys(language);
		driver.findElement(By.id("cast")).sendKeys(cast);
		driver.findElement(By.id("rating")).sendKeys(rating);
		driver.findElement(By.id("trailer")).sendKeys(trailer);
		driver.findElement(By.id("review")).sendKeys(review);

		driver.findElement(By.cssSelector("#submitaddmovie")).click();
		Thread.sleep(2000);
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		File file = new File("C:/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);
		Thread.sleep(2000);
		AddMovie a = new AddMovie(driver);
		a.loginuser("admin@gmail.com", "12345");
		a.InsertMovie("test1","2018","/Content/image/abcd2.png","test","test","test","test","test");
	}

}
