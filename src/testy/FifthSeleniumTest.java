package testy;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.PropertiesFile;


public class FifthSeleniumTest {

	public static String browser ;
	static WebDriver driver;
	public static void main(String[] args) {

//		String projectLocation = System.getProperty("user.dir");
	
//		System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
//		WebDriver driver = new FirefoxDriver();
//		setBrowser();
//		WebDriver driver = new EdgeDriver();
// put into github maybe 7/24 or so
		
		PropertiesFile.readPropertiesFile();
		
		setBrowserConfig();
		
		runTests();
		PropertiesFile.writePropertiesFile();

	}


// Set browser
// Set browser config
// run tests

public static void setBrowser() {
	browser = "Firefox";
//	browser = "Chrome";
//	browser = "InternetExplorer";	
}

public static void setBrowserConfig() {
	String projectLocation = System.getProperty("user.dir");
	
	if (browser.contains("Firefox")) {
//		System.setProperty("webdriver.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
//		driver = new MarionetteDriver();
	}
	
	else if (browser.contains("Chrome")) {

// my machine doesn't have chrome		
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();

	}
	
//	else if (browser.contains("Edge")) {
//		System.setProperty("webdriver.edge.driver", projectLocation+"\\lib\\edgedriver\\edgedriver.exe");
//	
//		driver = new EdgeDriver();
//	}
	
	else if (browser.contains("InternetExplorer")) {
		System.setProperty("webdriver.ie.driver", projectLocation+"\\lib\\iedriverserver\\IEDriverServer.exe");
//		System.setProperty("webdriver.ie.logfile", projectlocation+ "IEDriverServer.log");

//		System.setProperty("webdriver.ie.driver", IEDriverLocation);
//        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//        caps.setCapability("ignoreZoomSetting", true);
//        caps.setCapability("nativeEvents",false);
//                  driver = new InternetExplorerDriver(caps);
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.ignoreZoomSettings();
        options.setCapability("nativeEvents",false);
        options.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1);		

//        options.setCapability("nativeEvents", false);
        options.setCapability("unexpectedAlertBehaviour", "accept");
        options.setCapability("ignoreProtectedModeSettings", true);
        options.setCapability("disable-popup-blocking", true);
        options.setCapability("enablePersistentHover", true);
        options.setCapability("ignoreZoomSetting", true);
        
        driver = new InternetExplorerDriver(options);
		
	}
}

public static void runTests() {
//	driver.get("http://seleniumhq.org/");
	driver.get("http://automationpractice.com//index.php");
	
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	
	runTestA_LookInAutomationPracticeSite();
	runTestB_ShowDataInSecondPage();
	runTestC_PlayWithXpathsInLegal();

	

	driver.quit();
	
}

public static void runTestA_LookInAutomationPracticeSite() {
	try {
		WebElement link = driver.findElement(By.id("search_block_top"));
		WebElement link2 = driver.findElement(By.linkText("T-SHIRTS"));

		System.out.println("found search block top section");
		System.out.println(link.getTagName());
		System.out.println(link.getText());
		System.out.println(link2.getTagName());
		System.out.println(link2.getText());
		List<WebElement> rows =  driver.findElements(By.id("search_block_top")); //driver.findElements(By.id("block_top_menu"));

		// print the total number of elements
		System.out.println("Total selected rows are " + rows.size());

		// Now using Iterator we will iterate all elements
		Iterator<WebElement> iter = rows.iterator();

		int i=0;
		// this will check whether list has some element or not
		while (iter.hasNext() && (i < 10)) {

			// Iterate one by one
			WebElement item = iter.next();

			// get the text
			String label = item.getText();

			// print the text
			System.out.println("Row label is " + label);
			
			i++;
		}
	
		
//		link.findElements("");
//		System.out.println(link.);
//		System.out.println(link.getTagName());
//		System.out.println(link.getTagName());
		if (browser.contains("InternetExplorer"))
			link2.sendKeys(Keys.ENTER);
		else 
			link2.click();
	}
	catch (Exception e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

// 	This is done after navigating to the new page

public static void runTestB_ShowDataInSecondPage () {
	try {
		WebElement link = driver.findElement(By.id("ul_layered_id_attribute_group_1"));

		System.out.println("found ul_layered_id_attribute_group_1");
		System.out.println(link.getTagName());
		System.out.println(link.getText());
		List<WebElement> rows =  driver.findElements(By.id("ul_layered_id_attribute_group_1")); //driver.findElements(By.id("block_top_menu"));

		// print the total number of elements
		System.out.println("Total selected rows are " + rows.size());

		// Now using Iterator we will iterate all elements
		Iterator<WebElement> iter = rows.iterator();

		int i=0;
		// this will check whether list has some element or not
		while (iter.hasNext() && (i < 10)) {

			// Iterate one by one
			WebElement item = iter.next();

			// get the text
			String label = item.getText();

			// print the text
			System.out.println("Row label is " + label);
			
			i++;
		}
	
		
//		link.findElements("");
//		System.out.println(link.);
//		System.out.println(link.getTagName());
//		System.out.println(link.getTagName());
		
//		link2.click();
	}
	catch (Exception e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public static void runTestC_PlayWithXpathsInLegal() {
	try {
		// Absolute path
//		WebElement item = driver.findElement(By.xpath("html/head/body/table/tr/td"));
		WebElement item = driver.findElement(By.xpath("html"));
/*		item = driver.findElement(By.xpath("html/body"));
		System.out.println("id: "+item.getAttribute("id"));
		item = driver.findElement(By.xpath("html/body/div"));
		System.out.println("id: "+item.getAttribute("id"));
		item = driver.findElement(By.xpath("html/body/div/div[1]"));
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]"));
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div"));  // fails here
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]"));
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div"));
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div/section"));
		System.out.println("id: "+item.getAttribute("id"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div/section/div"));
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div/section/div/ul"));
		System.out.println("class: "+item.getAttribute("class"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div/section/div/ul/li[2]"));
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div/section/div/ul/li[2]/a"));
 */
		item = driver.findElement(By.xpath("html/body/div/div[2]/div/div[3]/div/section/div/ul/li[2]/a"));
		System.out.println("going to legal notice:"+item.getAttribute("title"));
		System.out.println("class: "+item.getAttribute("class") +"  text: "+item.getText() +	"  href: "+item.getAttribute("href"));
		enterClick(item);
//		if (browser.contains("InternetExplorer"))
//			item.sendKeys(Keys.ENTER);			// ie can't handle clicking
//		else 
//			item.click();
//		item.click();
// you cannot use an item after it has been clicked out of		
//		System.out.println("went to legal notice"+item.getAttribute("title"));
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		WebElement elListo = driver.findElement(By.xpath("html/body/div/div[3]/footer/div/section[3]/ul"));
		System.out.println("class: "+elListo.getAttribute("class"));
// original 		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
		List<WebElement> allLinks = driver.findElements(By.xpath("html/body/div/div[3]/footer/div/section[3]/ul/li/a"));

		Iterator<WebElement> itr = allLinks.iterator();
		int i = 1 ;
		while(itr.hasNext()) {
			WebElement listItem = itr.next();
			String label = listItem.getAttribute("title");

		    System.out.println("list item" + i++ + ": " +label);
		}		
	}
	catch (Exception e)  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

// internet explorer has problems for now
// instead of clicking on an item, ie works when you send an ENTER key. Other browsers click.

public static void enterClick(WebElement anItem) {
	try {
		if (browser.contains("InternetExplorer"))
			anItem.sendKeys(Keys.ENTER);			// ie can't handle clicking
		else 
			anItem.click();
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}

