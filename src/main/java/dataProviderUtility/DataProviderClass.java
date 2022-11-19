package dataProviderUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import excelUtility.XLUtility;
import io.github.bonigarcia.wdm.WebDriverManager;




public class DataProviderClass {

		public String [][] getData(String sheetName) throws IOException
		{
			String path = "testData\\testData.xlsx";
			XLUtility xlUtils = new XLUtility(path);
			int totalRows = xlUtils.getRowCount(sheetName);
			int totalCols = xlUtils.getCellCount(sheetName, totalRows);
			String RegData [][] = new String[totalRows][totalCols];
			totalRows=totalRows+1;
			
			for(int i=1;i<totalRows;i++)
			{
				for(int j=0;j<totalCols;j++)
				{
					RegData [i-1][j]=xlUtils.getCellData(sheetName, i, j);
				}
			}
			return RegData;
		}
}
