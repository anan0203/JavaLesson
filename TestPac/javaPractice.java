package TestPac;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;

import java.io.File;

import junit.framework.TestCase;

public class javaPractice extends TestCase {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin","E:/Program Files/Mozilla Firefox/firefox.exe"); 
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		//WebDriver driver=new FirefoxDriver();
		Thread.sleep(2000);
		System.out.println("maximize browser");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		Dimension dimension=new Dimension(1350,750);
		driver.manage().window().setSize(dimension);
		
		String firstUrl="http://www.baidu.com";
		System.out.printf("now access %s \n",firstUrl);
		driver.get(firstUrl);
		Thread.sleep(2000);
		System.out.printf("tittle of current page is: %s\n",driver.getTitle());
		System.out.printf("url of current page is: %s\n",driver.getCurrentUrl());
		
		String secondUrl="http://www.soso.com";
		System.out.printf("now access %s\n",secondUrl);
		driver.get(secondUrl);
		Thread.sleep(2000);
		
		System.out.printf("now back to %s \n",firstUrl);
		driver.navigate().back();
		Thread.sleep(1000);
		
		System.out.printf("forward to %s \n",secondUrl);
		driver.navigate().forward();
		Thread.sleep(1000);
		
		System.out.println("browser will be closed");
		driver.quit();
		System.out.println("browser is closed");
		
		//SimpleLocate simpleLocate=new SimpleLocate();
		//simpleLocate.LocateTest();
		
		//NewSimpleLocate newSimpleLocate=new NewSimpleLocate();
		//newSimpleLocate.NewLocateTest();*/
		
		//LevelLocate levelLocate=new LevelLocate();
		//levelLocate.LevelLocateFun();
		
		//OperateElement operateElement=new OperateElement();
		//operateElement.OperateElementFun();
		
		//SendKeys sendKeys=new SendKeys();
		//sendKeys.SendKeysFun();
		
		//ButtonGroup buttonGroup=new ButtonGroup();
		//buttonGroup.ButtonGroupFun();
		
		//ButtonDropdown buttonDropdown=new ButtonDropdown();
		//buttonDropdown.ButtonDropdownFun();
		
		//Navs navs=new Navs();
		//navs.NavsFun();
		
		//Breadcrumb breadcrumb=new Breadcrumb();
		//breadcrumb.BreadcrumbFun();
		
		//Modal modal=new Modal();
		//modal.ModalFun();
		
		//Attribute attribute=new Attribute();
		//attribute.AttributeFun();
		
		//Css css=new Css();
	        //css.CssFun();
		
		//Status status=new Status();
		//status.StatusFun();
		
		//Form1 form1=new Form1();
		//form1.Form1Fun();
		
		//JS js=new JS();
		//js.JSFun();
		
		//AlertExample alertExample=new AlertExample();
		//alertExample.AlertExampleFun();
		
		//WaitExample waitExample=new WaitExample();
		//waitExample.WaitExampleFun();
		
		Frame frame=new Frame();
		frame.FrameFun();
	}
}

class OpenWebDriver{
	String fileStore;
	public OpenWebDriver(String fStore)
	{
		fileStore=fStore;
	}
	
	public WebDriver OpenWebDriverFun() throws InterruptedException
	{		
		System.setProperty("webdriver.firefox.bin","E:/Program Files/Mozilla Firefox/firefox.exe"); 
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		File file=new File(fileStore);
		String filePath="file:///"+file.getAbsolutePath();
		System.out.printf("now access %s \n",filePath);
		
		driver.get(filePath);
		Thread.sleep(2000);
		return driver;
	}
}


class SimpleLocate{
	public void LocateTest() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin","E:/Program Files/Mozilla Firefox/firefox.exe"); 
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		
		File file=new File("src/form.html");
		String filePath="file:///"+file.getAbsolutePath();
		System.out.printf("now access %s \n",filePath);
		
		driver.get(filePath);
		Thread.sleep(2000);
		
		//bu id
		driver.findElement(By.id("inputEmail")).click();
		Thread.sleep(1000);
		
		//by name
		driver.findElement(By.name("password"));
		Thread.sleep(1000);
		
		//by tagname
		String classOfForm=driver.findElement(By.tagName("form")).getAttribute("class");
		System.out.printf("class of form is %s \n",classOfForm);
		Thread.sleep(1000);
		
		//by link text
		WebElement link=driver.findElement(By.linkText("register"));
		((JavascriptExecutor)driver).executeScript("$(arguments[0]).fadeOut().fadeIn",link);
		Thread.sleep(1000);
		
		//by partial link test
		WebElement sameLink=driver.findElement(By.partialLinkText("reg"));
		((JavascriptExecutor)driver).executeScript("$(arguments[0]).fadeOut().fadeIn",sameLink);
		Thread.sleep(1000);
		
		//by css selector  ��������ѡ�������Ǻ�����
		WebElement div=driver.findElement(By.cssSelector(".controls"));
		((JavascriptExecutor)driver).executeScript("$(arguments[0]).fadeOut().fadeIn",div);
		Thread.sleep(1000);
		
		//by xpath
		driver.findElement(By.xpath("/html/body/form/div[3]/div/label/input")).click();
		Thread.sleep(1000);
		
		System.out.println("browser will be closed");
		driver.quit();
	}
}

class NewSimpleLocate{
	public void NewLocateTest() throws InterruptedException
	{
		/*System.setProperty("webdriver.firefox.bin","E:/Program Files/Mozilla Firefox/firefox.exe"); 
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		
		File file=new File("src/checkbox.html");
		String filepath="file:///"+file.getAbsolutePath();
		System.out.printf("now access %s \n", filepath);
		
		driver.get(filepath);
		Thread.sleep(1000);*/
		String fileP="src/checkbox.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//ѡ�����е�checkbox��ȫ������
		List<WebElement> checkboxes=driver1.findElements(By.cssSelector("input[type=checkbox]"));
		for(WebElement checkbox : checkboxes){
			checkbox.click();
		}
		driver1.navigate().refresh();
		
		//��ӡ��ǰҳ���ж���checkbox
		System.out.printf("%d \n", checkboxes.size());
		
		//ѡ��ҳ�������е�input��Ȼ�����й��˳����е�checkbox����ѡ֮
		List<WebElement> inputs=driver1.findElements(By.tagName("input"));
		for(WebElement input : inputs)
		{
			if(input.getAttribute("type").equals("checkbox"))
			{
				input.click();
			}
		}
		
		//��ҳ������һ��checkbox�Ĺ�ȥ��
		 List<WebElement> allCheckboxes = driver1.findElements(By.cssSelector("input[type=checkbox]"));
         allCheckboxes.get(allCheckboxes.size() - 1).click();
         Thread.sleep(1000);
         
         System.out.println("browser will be close");
         driver1.quit();  
	}	
}

class LevelLocate {
	public void LevelLocateFun() throws InterruptedException
	{	
		String fileP="src/level_locate.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();

		
		driver1.findElement(By.linkText("Link1")).click();
		(new WebDriverWait(driver1, 10)).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d){
                return d.findElement(By.id("dropdown1")).isDisplayed();
            }
        } );
		
		WebElement menu = driver1.findElement(By.id("dropdown1")).findElement(By.linkText("Another action"));
        (new Actions(driver1)).moveToElement(menu).perform();

        Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  

	}
	
	
}

class OperateElement{
	public void OperateElementFun() throws InterruptedException
	{
		
		String fileP="src/operate_element.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//click
		driver1.findElement(By.linkText("Link1")).click();
		Thread.sleep(1000);
		driver1.findElement(By.linkText("Link1")).click();
		
		//send_keys
		/*WebElement element=driver1.findElement(By.name("q"));
		element.sendKeys("somethings");
		Thread.sleep(1000);
		
		element.clear();*/
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
			
	}
}

class SendKeys{
	public void SendKeysFun() throws InterruptedException
	{
		String fileP="src/send_keys.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//copy content of A
		driver1.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Thread.sleep(1000);
		driver1.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL+"x"));
		
		//paste to B
		driver1.findElement(By.id("B")).sendKeys(Keys.chord(Keys.CONTROL+"v"));
		
		//sendKeys to A
		driver1.findElement(By.id("A")).sendKeys(Keys.chord("This is my test"));
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
	}
}

class ButtonGroup{
	public void ButtonGroupFun() throws InterruptedException
	{
		String fileP="src/button_group.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//��λtext��second�İ�ť
		List<WebElement> btns=driver1.findElement(By.className("btn-group")).findElements(By.className("btn"));
		for(WebElement btn:btns)
			if(btn.getText().equals("second"))
			{
				btn.click();
				break;
			}
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
	}
}

class ButtonDropdown {
	public void ButtonDropdownFun() throws InterruptedException
	{
		String fileP="src/button_dropdown.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		driver1.findElement(By.linkText("Info")).click();
		
		(new WebDriverWait(driver1,10)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
				return d.findElement(By.className("dropdown-menu")).isDisplayed();
			}
		}
		
				);
		
		driver1.findElement(By.className("dropdown-menu")).findElement(By.linkText("watir-webdriver")).click();
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
		
	}
}

class Navs{
	public void NavsFun() throws InterruptedException
	{
		String fileP="src/Navs.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//1 �㼶��λ
		//driver1.findElement(By.className("nav nav-pills")).findElement(By.linkText("About")).click();
		
		//2 ֱ�Ӷ�λ
		driver1.findElement(By.linkText("About")).click();
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
	}
}

class Breadcrumb{
	public void BreadcrumbFun() throws InterruptedException
	{
		String fileP="src/breadcrumb.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//���ø��㼶
		List<WebElement> ancestors=driver1.findElement(By.className("breadcrumb")).findElements(By.tagName("a"));
		for(WebElement links : ancestors)
		{ 
			System.out.println(links.getText());
			}
		
		//�㼶��λ
		WebElement current = driver1.findElement(By.className("breadcrumb")).findElement(By.className("active"));
        System.out.println(current.getText());
        
        Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
	}
}

class Modal{
	public void ModalFun() throws InterruptedException
	{
		String fileP="src/modal.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		driver1.findElement(By.id("show_modal")).click();
		
		(new WebDriverWait(driver1, 10)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.findElement(By.id("myModal")).isDisplayed();
                    }
                }
        );
		
		//��js��ģ��click
		WebElement clickT=driver1.findElement(By.id("myModal")).findElement(By.id("click"));
		((JavascriptExecutor)driver1).executeScript("$(arguments[0]).click()",clickT);
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit(); 
	}
}

class Attribute{
	public void AttributeFun() throws InterruptedException
	{
		String fileP="src/attribute.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		WebElement link = driver1.findElement(By.id("tooltip"));
		
		//����tooltip����   ������̫����
		System.out.println(link.getAttribute("data-original-title"));
		
		//��ȡ�����ӵ�text
		 System.out.println(link.getText());

         Thread.sleep(1000);
         System.out.println("browser will be close");
         driver1.quit();  
		
	}
}

class Css{
	public void CssFun() throws InterruptedException
	{
		String fileP="src/css.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		WebElement link = driver1.findElement(By.id("tooltip"));
        System.out.println(link.getCssValue("color"));
        Thread.sleep(1000);
        System.out.println(driver1.findElement(By.tagName("h3")).getCssValue("font-family"));
        

        Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
	}
}

class Status{
	public void StatusFun() throws InterruptedException
	{
		String fileP="src/status.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		WebElement textField=driver1.findElement(By.name("user"));
		System.out.println(textField.isEnabled());
		
		//�ж�Button״̬����������
		 System.out.println(driver1.findElement(By.className("btn")).isEnabled());
		 
		 //���ص�textField  �ж����Ƿ���ʾ
		 ((JavascriptExecutor)driver1).executeScript("$(arguments[0]).hide()", textField);
         System.out.println(textField.isDisplayed());
         
         //��click����ѡ��radio
         WebElement radio=driver1.findElement(By.name("radio"));
         radio.click();
         System.out.println(radio.isSelected());
         
         try{
        	 driver1.findElement(By.id("none"));
         }
         catch(NoSuchElementException e){
        	 System.out.println("element does not exist");
         }
         
         Thread.sleep(1000);
         System.out.println("browser will be close");
         driver1.quit();  

	}
}

class Form1{
	public void Form1Fun() throws InterruptedException
	{
		String fileP="src/form1.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//ѡ��checkbox
		driver1.findElement(By.cssSelector("input[type=checkbox]")).click();
		
		//ѡ��radio
		driver1.findElement(By.cssSelector("input[type=radio]")).click();
		
		//ѡ�������˵�����һ��
		List<WebElement> options = driver1.findElement(By.tagName("select")).findElements(By.tagName("option"));
		options.get(options.size()-1).click();
		
		//�����ύ��ť
		driver1.findElement(By.cssSelector("input[type=submit]")).click();
		
		//��ȡalert����
		Alert alert=driver1.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit();  
	}
}

class JS{
	public void JSFun() throws InterruptedException
	{
		String fileP="src/js.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//ҳ��ֱ��ִ��JS
		((JavascriptExecutor)driver1).executeScript("$('#tooltip').fadeOut");
		Thread.sleep(1000);
		
		//�ڶ�λԪ����ִ��js
		WebElement button=driver1.findElement(By.className("btn"));
		((JavascriptExecutor)driver1).executeScript("$(arguments[0]).fadeOut();",button);
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit(); 
	}
}

class AlertExample{
	public void AlertExampleFun() throws InterruptedException
	{
		String fileP="src/alert.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		 driver1.findElement(By.id("tooltip")).click();
         Alert alert = driver1.switchTo().alert();
         alert.accept();
         
         Thread.sleep(1000);
         System.out.println("browser will be close");
         driver1.quit(); 

	}
}

class WaitExample{
	public void WaitExampleFun() throws InterruptedException
	{
		String fileP="src/wait.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		//���ⲻ����
		driver1.findElement(By.id("btn")).click();
		(new WebDriverWait(driver1,10)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
				return d.findElement(By.className("label")).isDisplayed();
			}
		}
		
				);
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit(); 

	}
}

class Frame{
	public void FrameFun() throws InterruptedException
	{
		String fileP="src/frame.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		driver1.switchTo().frame("f1");
		driver1.switchTo().frame("f2");
		
		driver1.findElement(By.id("kw1")).sendKeys("watir-webdriver");
        Thread.sleep(1000);
        
        //��������frame
        driver1.switchTo().defaultContent();
        
        driver1.switchTo().frame("f1");
        driver1.findElement(By.linkText("click")).click();

        Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit(); 
	}
}

class Action{
	public void ActionFun() throws InterruptedException{
	String fileP="src/frame.html";
	OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
	WebDriver driver1=openWebDriver.OpenWebDriverFun();
	Actions action=new Actions(driver1);
	
	action.keyDown(Keys.SHIFT);
	             
	}
}

class Upload{
	public void UploadFun() throws InterruptedException
	{
		String fileP="src/frame.html";
		OpenWebDriver openWebDriver=new OpenWebDriver(fileP);
		WebDriver driver1=openWebDriver.OpenWebDriverFun();
		
		driver1.findElement(By.cssSelector("input[type=file]")).sendKeys("src/navs.html");
		
		Thread.sleep(1000);
        System.out.println("browser will be close");
        driver1.quit(); 
	}
}

class Others{
	public void DownloadFun()
	{
		//driver = Selenium::WebDriver.for :chrome, :profile => profile  ����???????
		//# for firefox
		FirefoxProfile firefoxProfile=new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList",2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		firefoxProfile.setPreference("browser.download.dir","c:\\downloads");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");

		  WebDriver driver = new FirefoxDriver(firefoxProfile);		
		  driver.navigate().to("http://www.myfile.com/hey.csv");

		
		
	}
	
	public void timeOut()
	{
		 WebDriver driver = new FirefoxDriver();
		 //����3s�ڻ���λ�������׳��쳣
		 driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		 //ҳ�����س�ʱʱ������Ϊ5s
		 driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		 //�첽�ű��ĳ�ʱʱ�����ó�3s 
		 driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
	}
}

class CookieExample{
	public void CookieExampleFun() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
        String url = "http://www.baidu.com";
        System.out.printf("now accesss %s \n", url);
        driver.get(url);
        Thread.sleep(2000);
        
        driver.manage().deleteAllCookies();
        Cookie c1=new Cookie("BAIDUID","xxxxxxxx");
        Cookie c2=new Cookie("BDUSS","xxxxxxxx");
        
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        
        System.out.println("browser will be close");
        driver.quit();
        
	}
}

class RemoteWebdriver{
	public void RemoteWebdriverFun()
	{
		// We could use any driver for our tests...
	    DesiredCapabilities capabilities = new DesiredCapabilities();

	    // ... but only if it supports javascript
	    capabilities.setJavascriptEnabled(true);

	    // Get a handle to the driver. This will throw an exception
	    // if a matching driver cannot be located
	    WebDriver driver = new RemoteWebDriver(capabilities);

	    // Query the driver to find out more information
	    Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();

	    // And now use it
	    driver.get("http://www.google.com");
	}
}
