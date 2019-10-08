package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg {
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("----- beforeTest------");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("----- afterTest------");
	}
	
	/*@BeforeGroups
	public void beforeGroups(){
		System.out.println("----- beforeGroups------");
	}*/
	
	
	@Parameters({"sname","name"})
	@Test()
	public void zfirstTest(String name,String same){
		System.out.println("----- First Test---"+name+"---"+same+"----");
	}
	
	@Test
	public void aSecondTest(){
		System.out.println("----- 2 Test------");
	}
	
	@Test
	public void athirdTest(){
		System.out.println("----- 3 Test------");
	}
	
	/*@BeforeMethod
	public void beforeMethod(){
		System.out.println("----- beforeMethod------");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("----- afterMethod------");
	}*/

}
