package myPackage;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DeleteMovieTest {
	
	@Test
	public void f() throws Exception {
		WebDriver driver;
		File file = new File("C:/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new InternetExplorerDriver();
		driver.get(url);

		DeleteMovie movie = new DeleteMovie(driver);
		movie.loginuser("admin@gmail.com", "12345");

		Scanner scan = new Scanner(new File("deletemovies.txt"));

		while (scan.hasNextLine()) {
			String name = scan.nextLine();
			movie.RemoveMovie(name);
			// Assert.assertEquals(movie.find(name));
		}

		scan.close();
	}
	
	@Test
	public void f1() throws Exception {
		WebDriver driver;
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new GoogleChromeDriver();
		driver.get(url);

		DeleteMovie movie = new DeleteMovie(driver);
		movie.loginuser("admin@gmail.com", "12345");

		Scanner scan = new Scanner(new File("deletemovies.txt"));

		while (scan.hasNextLine()) {
			String name = scan.nextLine();
			movie.RemoveMovie(name);
			// Assert.assertEquals(movie.find(name));
		}

		scan.close();
	}
	
	@Test
	public void f2() throws Exception {
		WebDriver driver;
		File file = new File("C:/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new FirefoxDriver();
		driver.get(url);

		DeleteMovie movie = new DeleteMovie(driver);
		movie.loginuser("admin@gmail.com", "12345");

		Scanner scan = new Scanner(new File("deletemovies.txt"));

		while (scan.hasNextLine()) {
			String name = scan.nextLine();
			movie.RemoveMovie(name);
			// Assert.assertEquals(movie.find(name));
		}

		scan.close();
	}
}
