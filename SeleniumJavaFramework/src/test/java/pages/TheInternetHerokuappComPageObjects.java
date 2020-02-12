package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheInternetHerokuappComPageObjects {

	WebDriver driver = null; 

	By javascriptalerts_link_click = By.xpath("//a[@href='/javascript_alerts']");

	By button_click = By.xpath("//button[contains(text(),'Click for JS Confirm')]");

	By result_confirm = By.xpath("//div[@class='example']/p[2]");

	public TheInternetHerokuappComPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public void javascriptalertslinkclick() {

		driver.findElement(javascriptalerts_link_click).click();
	}

	public void buttonclick() {

		driver.findElement(button_click).click();
	}


	public WebElement resultconfirm() {
		WebElement links = driver.findElement(result_confirm);
		return links;




	}


}


