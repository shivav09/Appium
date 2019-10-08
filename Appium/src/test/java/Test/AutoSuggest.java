package Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.functions.ExpectedCondition;

public class AutoSuggest {
	
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://google.com");
		 WebElement searchBox=driver.findElement(By.id("lst-ib"));
		 searchBox.sendKeys("Test");
		Thread.sleep(5000);
		/*Select sel= new Select(searchBox);
		List<WebElement> opt=sel.getOptions();
		opt.get(0).getText();*/
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver).withTimeout(10,TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.elementToBeClickable(searchBox));
		//wait.until(ExpectedConditions.)
		// System.out.println(driver.findElement(By.id("ls-ib")).isDisplayed());
		 List<WebElement> list= driver.findElements(By.xpath("//div[@class='sbqs_c']"));
		 for(int i=0;i<list.size();i++){
		 System.out.println(list.get(i).getText());
		 if(list.get(i).getText().equals("test ranking")){
			 list.get(i).click();
			 
		 }
		 }
		 driver.quit();
		 
	}

}
