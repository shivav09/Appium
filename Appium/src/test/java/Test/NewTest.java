package Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	@Parameters("name")
	@Test(priority='1')
	public void bFirstTest(String name){
		System.out.println("----- New Test class 1 test------"+name+"----");
	}
	
	@Test(priority='2')
	public void aSecondTest(){
		System.out.println("----- New Class 2 Test------");
	}
}
