package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.media.sound.InvalidFormatException;


public class BB {
	static WebDriver driver;
	
	@BeforeTest
	public static void launchGoogle(){
		driver=  new ChromeDriver();
		driver.get("http:\\google.com");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="LoginCredentials")
	public static void googleSignIn(String uName,String pwd){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		if(driver.findElements(By.xpath("//content[starts-with(text(),'Hi ')]")).size()!=0)
		{
			driver.findElement(By.id("profileIdentifier")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//button[text()='Remove an account']")).click();
			driver.findElement(By.xpath("(//div[@aria-hidden='true'])[4]")).click();
			driver.findElement(By.xpath("//span[text()='Yes, remove']")).click();
		}
		
		driver.findElement(By.id("identifierId")).sendKeys(uName);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//span[text()='Next']")).click();		
		navigateToBB();
		voteForKK50();
		success();
		logout();
		
	}
	
	
	public  static void navigateToBB(){
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("Bigg Boss Telugu vote");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	}
	
	public static void voteForKK50(){
		driver.findElement(By.xpath("//div[text()='Kaushal ']")).click();
		Actions act= new Actions(driver);
		WebElement slider=driver.findElement(By.xpath("//div[@class='P5gHHf oqEZkc']"));
		act.dragAndDropBy(slider, 500, 0).perform();
		driver.findElement(By.xpath("//div[text()='Continue']")).click();
	}
	
	public static void logout(){
		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}
	
	public static void success(){
		driver.findElement(By.xpath("//div[text()='Vote']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[text()='Done']")).click();
		
	}
	
	@DataProvider(name="LoginCredentials")
	public Object[][] loginData() throws InvalidFormatException, IOException {
		
		Object[][] arrayObject = getCellData("C:\\Users\\Vallabhaneni\\Desktop\\test.xls","login");
		return arrayObject;
	}
	
	public Object[][] getCellData(String path, String sheetName) throws InvalidFormatException, IOException {
			FileInputStream fis= new FileInputStream(path);
			Workbook wb = new HSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
		  int rowcount = sheet.getLastRowNum();
		  int cellcount = sheet.getRow(0).getLastCellNum();
		  String data[][] = new String[rowcount][cellcount];
		  for (int i = 1; i <=rowcount; i++) {
		   Row r = sheet.getRow(i);
		   for (int j = 0; j <cellcount; j++) {
		   Cell c = r.getCell(j);
		   c.setCellType(Cell.CELL_TYPE_STRING);
		      data[i - 1][j] = c.getStringCellValue();
		   }
		  }
		  wb.close();
		  return data;
		 
		 }
}
