package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.util.Duration;

public class MobileAutomation {
	static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
		//caps.setCapability("deviceName", "Android Device");
		//caps.setCapability("udid", "CI858PPNT44L8HGU"); //Give Device ID of your mobile phone
		//caps.setCapability("platformName", "Android");
		//caps.setCapability("platformVersion", "6.0");
		caps.setCapability("appPackage", "com.touchboarder.android.api.demos");
		caps.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		caps.setCapability("noReset", "true");
		
		try {
				 driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.getContext();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.hideKeyboard();
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		TouchAction ta= new TouchAction(driver);
		//ta.longPress(driver.Fi(By.)).
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		TouchAction act = new TouchAction(driver);
		
		/*driver.findElementByAndroidUIAutomator("new UiSelector().text(\"API Demos\")").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView("
				+ "new UiSelector().text(\"Views\"))").click();// To scroll to a text and Click
				driver.pressKeyCode(AndroidKeyCode.BACK);
				driver.pressKeyCode(AndroidKeyCode.BACK);
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Support v4 Demos\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Widget\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"SwipeRefreshLayout\")").click();
		
		act.press(driver.findElementByAndroidUIAutomator
				("new UiSelector().resourceId(\"android:id/text1\")")).waitAction
					(java.time.Duration.ofMillis(2000)).moveTo(driver.findElementByAndroidUIAutomator
						("new UiSelector().text(\"Richard III\")")).release().perform();*/ // scroll down to refresh
		/*driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Support v4 Demos\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Media\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"TransportController\")").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.touchboarder.android.api.demos:id/pause\")").click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElement(By.id("com.touchboarder.android.api.demos:id/time_current")).getText().equals("00:09")){
			System.out.println("Played Successfully");
			
		}*/ // video player
		
		
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Support v7 Demos\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"AppCompat\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Action Bar\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Preferences\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Edit text preference\")").click();
		driver.findElementById("android:id/edit").sendKeys("Vallabhaneni");
		driver.findElementById("android:id/button1").click();
		WebElement element =driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.RatingBar\")");
		int startX = element.getLocation().getX();
		int endX = element.getSize().getWidth();
		  int yAxis = element.getLocation().getY();
		  int tapAt = (int) (endX * 0.5);    
		  act.press(tapAt,yAxis).release().perform(); // Rating Bar
		act.longPress(element, java.time.Duration.ofMillis(2000)).moveTo(element).tap(element).perform();
	}
	
	

}
