package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchHappyPath {
	@Test
	public void search(){
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://link.springer.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Engineering")).click();
		String happypath=driver.getCurrentUrl();
		System.out.println(happypath);
		String resultcount=driver.findElement(By.xpath("//*[@id='kb-nav--main']/div[1]")).getText();
		System.out.println(resultcount);
		//===Happy path result ==================
		driver.get(happypath);
		String hpresultcount=driver.findElement(By.xpath("//*[@id='kb-nav--main']/div[1]")).getText();
		
		if(resultcount.equalsIgnoreCase(hpresultcount)){
			System.out.println("Happy path working correctly, and matching the results correctly");
		}else{
			System.out.println("Happy path not working correctly");
		}
		
		//=========Check with Unhappy path====================
		driver.get("https://link.springer.com/search?facet-discipline=%22EnginGGGGGGGGGGGGGGGGeering%22");
		String uhpresultcount=driver.findElement(By.xpath("//*[@id='kb-nav--main']/div[1]")).getText();
		if(!resultcount.equalsIgnoreCase(uhpresultcount)){
			System.out.println("Un happy path working correctly");
		}else{
			System.out.println("Un happy path is not working correctly, matching with any result");
		}
		
	}

}
