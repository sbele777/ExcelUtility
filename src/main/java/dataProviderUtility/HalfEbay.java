
package dataProviderUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtility.XLUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HalfEbay {

	WebDriver driver;
	@BeforeMethod
	public void setUP() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	
	@DataProvider(name="FormData")
	public String [][] getData() throws IOException
	{
		/*String path = "src\\main\\java\\testData\\testData.xlsx";
		XLUtility xlUtils = new XLUtility(path);
		int totalRows = xlUtils.getRowCount("Orange");
		int totalCols = xlUtils.getCellCount("Orange", totalRows);
		String RegData [][] = new String[totalRows][totalCols];
		totalRows = totalRows+1;
		for(int i=1;i<totalRows;i++)
		{
			for(int j=0;j<totalCols;j++)
			{
				RegData [i-1][j]=xlUtils.getCellData("Orange", i, j);
			}
		}
		
		return RegData;*/
		DataProviderClass dp = new DataProviderClass();
		String RegData [][] = dp.getData("Orange");
		return RegData;
	}
	
	@Test(dataProvider="FormData")
	public void halfEbayRegistration(String username,String password)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
