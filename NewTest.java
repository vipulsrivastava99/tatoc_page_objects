package com.qait.tatocobject.tatobject;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class NewTest {
	WebDriver driver;
	welcomePage page1;
	GridGate grid;
	FrameDungeon fd;
  @BeforeTest
  public void launchBrowser()
  {
      driver = new ChromeDriver();
   //   System.setProperty("webdriver.chrome.driver","C:\\Users\\Vipulsrivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
      driver.get("http://10.0.1.86/tatoc");
      page1 = new welcomePage(driver);
  }
  @AfterClass
  public void closeBrowser(){
      //driver.quit();
  }
  @Test(priority=1)
  public void checkBasicCourseLink()
  {
	  page1.OnClickBasicCourse();
	  String expectedUrl = "http://10.0.1.86/tatoc/basic/grid/gate";
		Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
  }
  @Test(priority=2)
  public void checkGreenBox()
  {
	 //grid.OnClickGreenBox();
	  //driver.findElement(By.className("greenbox")).click();	
	  FrameDungeon fd=new FrameDungeon(driver);
	  fd.clickGreen();
	  String expectedUrl1 = "http://10.0.1.86/tatoc/basic/frame/dungeon";
		Assert.assertEquals(expectedUrl1, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
  }
  @Test(priority=3)
  public void ProceedIfBox1equalToBox2()
  {
	  FrameDungeon fdProceed = new FrameDungeon(driver) ;
	  fdProceed.RepaintBox2();
	  String expectedUrl = "http://10.0.1.86/tatoc/basic/drag";
		Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
  }
  @Test(priority=4)
  public void CheckDragAround()
  {
	  DragAround drag = new DragAround(driver) ;
	  drag.checkProceedAfterDragAndDrop();
	  String expectedUrl = "http://10.0.1.86/tatoc/basic/windows";
		Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
  }
  @Test(priority=5)
  public void CheckPopUpWindows()
  {
	  PopUpWindows popup = new PopUpWindows(driver) ;
	// popup.checkLaunchWindow();
	
	  popup.checkProceedAfterSubmittingName();
	  String expectedUrl1 = "http://10.0.1.86/tatoc/basic/cookie";
	  Assert.assertEquals(expectedUrl1, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
  }
  @Test(priority=6)
  public void CheckCookieHandling()
  {
	  CookieHandling cookie=new CookieHandling(driver);
	  cookie.checkProceedAfterTokenGeneration();
	  String expectedUrl1 = "http://10.0.1.86/tatoc/end";
		Assert.assertEquals(expectedUrl1, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
  }
}