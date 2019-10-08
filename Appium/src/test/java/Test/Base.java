package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverAction;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class Base {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.findElement(By.xpath("//div[@id='abc']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	driver.get("http://google.com");
		//driver.manage().window().setPosition(new Point(-2000,0)); // To minimize
	//	driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1000, 1000)); // to set window size
		/*List<WebElement> we=driver.findElements(By.xpath("//input"));
		System.out.println("===="+we.size());
		Iterator<WebElement> itr=we.iterator();
		while(itr.hasNext()){
			System.out.println("----  " +itr.next());
		}
		for(int i=0;i<we.size();i++){
			System.out.println(">>>>>  "+we.get(i));
		}
		driver.quit();*/
		
		/*File src= new File("C:\\Users\\Vallabhaneni\\Desktop\\test.xls");
		FileInputStream fis= new FileInputStream(src);
		Workbook wb = new HSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		System.out.println("RowCount : "+sheet.getLastRowNum());

		for(int i=0;i<rowCount;i++){
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				System.out.println("Cell Value : "+row.getCell(j).getStringCellValue());
			}
		}*/
		
		/*
		WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		int x=slider.getLocation().getX();
		int y=slider.getLocation().getY();
		Actions act = new Actions(driver);
		act.clickAndHold().moveToElement(slider).release().build().perform();
		Select sel= new Select(slider);
		List<WebElement> lt=sel.getOptions();
		for(int i=0;i<=lt.size();i++){
			lt.get(i).getText();
			System.out.println();
		}*/
		
		String str="";
		/*DesiredCapabilities cap1=DesiredCapabilities.firefox();
		cap1.setPlatform(Platform.WIN8);
		//WebDriver driver1=new RemoteWebDriver(new URL(null),cap1);
		 driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, 100, 0).perform();
		driver.switchTo().defaultContent();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[text()='Tabs']")));
		*/
		//driver.findElement(By.xpath("//a[text()='Tabs']"))
		Actions act = new Actions(driver);
		/*Set<String> st=driver.getWindowHandles();
		for(String win:st){
		if(driver.switchTo().window(win).getTitle().equals("asd")){
		}
		}*/
		//act.keyDown(Keys.ALT).keyDown(Keys.F2).build().perform();
		//Alert alert = driver.switchTo().alert();
/*		driver.getPageSource().contains("");
 
		Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
		
*/		
		driver.findElement(By.id("str")).sendKeys(Keys.ALT,"str");
		//driver.findElement(By.xpath("//input[@id='lst-ib']//following::input[3]")).click();
		//driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		//driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//wait1.until(ExpectedConditions.textToBePresentInElement(locator, text))
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.)
		Wait twait = new FluentWait<WebDriver>(driver)
				.withTimeout(45, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				;
		twait.until(ExpectedConditions.alertIsPresent());

	Select sel1 = new Select(driver.findElement(By.id("lst-ib")));
	//sel1.
	List<WebElement> li=sel1.getAllSelectedOptions();
	Iterator itr = li.iterator();
		for(int i=0;i<=li.size();i++){
			li.get(i).getText();
		}
		
	//	driver.get("http://demo.guru99.com/test/radio.html");
		
		File file = new File("C://Users//Vallabhaneni//Desktop//raja.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
		driver.getCurrentUrl();
		System.out.println("--- Name : "+prop.getProperty("name"));
	
		
Select sel11=new Select(driver.findElement(By.id("lst-ib")));

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("d:\\"));

	}
}
