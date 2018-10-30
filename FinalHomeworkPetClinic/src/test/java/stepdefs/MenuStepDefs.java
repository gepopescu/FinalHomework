package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class MenuStepDefs {
    WebDriver webDriver;

    @Given("^I go on the PetClinic site$")
    public void iGoOnThePetClinicSite() throws Throwable {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @When("^The users want to setup the webdriver$")
    public void theUsersWantToSetupTheWebdriver() throws Throwable {
        System.out.println(" The users want to setup the webdriver");
    }

    @Then("^The webdriver is setup$")
    public void theWebdriverIsSetup() throws Throwable {
        System.out.println(" The webdriver is setup");
    }


    @When("^The user click on the Home button if var is one or click on the springTab if var is zero , var= \"([^\"]*)\"$")
    public void theUserClickOnTheHomeButtonIfVarIsOneOrClickOnTheSpringTabIfVarIsZeroVar(int arg) throws Throwable {
        if (arg == 1){
            webDriver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
        }else{
            webDriver.findElement(By.xpath("//a[@class='navbar-brand']//span")).click();
        }
    }

    @Then("^The home page is displayed$")
    public void theHomePeageIsDisplayed() throws Throwable {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(webDriver.findElement(By.xpath("//h1[contains(text(),'Welcome to Petclinic')]")).isDisplayed());
        webDriver.quit();
    }


    @When("^The user click on the Owners button$")
    public void theUserClickOnTheOwnersButton() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Owners']")).click();
    }


    @Then("^A dropdown list appears for owners$")
    public void aDropdownListAppearsForOwners() throws Throwable {
        Assert.assertTrue(webDriver.findElement(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']")).isDisplayed());
        webDriver.quit();
    }

    @When("^The user click on the Veterinarians button$")
    public void theUserClickOnTheVeterinariansButton() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Veterinarians']")).click();
    }

    @Then("^A dropdown list appears for veterinarians$")
    public void aDropdownListAppearsForVeterinarians() throws Throwable {
      Assert.assertTrue(webDriver.findElement(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']")).isDisplayed());
      webDriver.quit();
    }

    @When("^The user click on the Pet Types button$")
    public void theUserClickOnThePetTypesButton() throws Throwable {
        webDriver.findElement(By.xpath("//span[contains(text(),'Pet Types')]")).click();
    }

    @Then("^The pet type page is displayed$")
    public void thePetTypePageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDriver.findElement(By.xpath("//h2[contains(text(),'Pet Types')]")).isDisplayed());
        webDriver.quit();
    }

    @When("^The user click on the Specialities button$")
    public void theUserClickOnTheSpecialitiesButton() throws Throwable {
        webDriver.findElement(By.xpath("//a[@title='specialties']")).click();
    }

    @Then("^The Specialities page is displayed$")
    public void theSpecialitiesPageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDriver.findElement(By.xpath("//h2[contains(text(),'Specialties')]")).isDisplayed());
        webDriver.quit();
    }
}
