package gradle.cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {
    
	WebDriver driver;

	@Before
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("I open wikipedia")
    public void i_open_wikipedia() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    @When("I search {string}")
    public void i_search(String article) {
	    WebElement searchBar = driver.findElement(By.name("search"));
        searchBar.sendKeys(article + Keys.ENTER);
    }

    @Then("I should see {string} in the title")
    public void i_should_see_in_the_title(String title) {
        WebElement titleElement = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(title, titleElement.getText());
    }

    @After
    public void afterScenario(){
        driver.quit();
    }
}
