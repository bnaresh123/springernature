package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Search {
	@Test
	public void search(){
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://link.springer.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("query")).sendKeys("earth");
		driver.findElement(By.id("search")).click();
		String resultcount =driver.findElement(By.xpath("//*[@id='kb-nav--main']/div[1]/h1")).getText();
		System.out.println(resultcount);
		String mydata=driver.findElement(By.xpath("//*[@id='results-list']/li[1]/h2")).getText();
		System.out.println(mydata);
		if(mydata.equalsIgnoreCase("earth")){
			System.out.println("We are getting proper result");
		}else{
			System.out.println("We are getting invalid result");
		}		
	}

}
