package stepdefs;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddNewOwnerStepDefs {
    WebDriver webDriver;
    List<WebElement> checkOwner;
    List<WebElement> nameOwner;
    List<WebElement> namePets;
    List<String> name;

    @Given("^I can navigate to petclinic site$")
    public void iCanNavigateToPetclinicSite() throws Throwable {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
       // webDriver.get("http://j3r3my.mywire.org:81/petclinic/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("^I complete the required fields as firstName \"([^\"]*)\",lastName \"([^\"]*)\", address \"([^\"]*)\",city \"([^\"]*)\",telephone \"([^\"]*)\"$")
    public void iCompleteTheRequiredFieldsAsFirstNameLastNameAddressCity(String firstname, String lastname, String address, String city,String telephone) throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Owners']")).click();
        webDriver.findElement(By.xpath("//a[@routerlink='/owners/add']//span[contains(text(),'Add New')]")).click();
        webDriver.findElement(By.id("firstName")).sendKeys(firstname);
        webDriver.findElement(By.id("lastName")).sendKeys(lastname);
        webDriver.findElement(By.id("address")).sendKeys(address);
        webDriver.findElement(By.id("city")).sendKeys(city);
        webDriver.findElement(By.id("telephone")).sendKeys(telephone);

//       webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//       webDriver.findElement(By.xpath("//*[@class='btn btn-default'][2]")).click();

    }


    @Then("^The Add new button is active and the user press it$")
    public void theAddNewButtonIsActiveAndTheUserPressIt() throws Throwable {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @And("^The new owner with first name \"([^\"]*)\" and last name \"([^\"]*)\" is present$")
    public void theNewOwnerWithFirstNameAndLastNameIsPresent(String firstName, String lastName) throws Throwable {
        checkOwner = webDriver.findElements(By.className("ownerFullName"));
        List<String> textList = new ArrayList<String>();
        for(WebElement we : checkOwner ) {
            textList.add(we.getText());
        }

        //System.out.println("a"+webDriver.findElement(By.xpath("//tbody//tr[2]//td[5]")).getText()+"a");
        Assert.assertTrue(textList.contains(firstName+" "+lastName));

        webDriver.quit();
    }


    @Then("^The message error is displayed$")
    public void theMessageErrorIsDisplayed() throws Throwable {
        String expectedText="Phone number only accept digits";
        String actualText = webDriver.findElement(By.xpath("//span[contains(text(),'Phone number only accept digits')]")).getText();
        Assert.assertTrue(expectedText.equals(actualText));
        //webDriver.quit();
    }

    @When("^I navigate in the add new owner page$")
    public void iNavigateInTheAddNewOwnerPage() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Owners']")).click();
        webDriver.findElement(By.xpath("//a[@routerlink='/owners/add']//span[contains(text(),'Add New')]")).click();
    }

    @Then("^Add New button is inactive$")
    public void addNewButtonIsInactive() throws Throwable {
        Assert.assertFalse(webDriver.findElement(By.xpath("//button[@type='submit']")).isEnabled());
        webDriver.quit();
    }


    @Then("^The message error is displayed for the First name field$")
    public void theMessageErrorIsDisplayedForTheFirstNameField() throws Throwable {
        String expectedText="First name must be at least 2 characters long";
        String actualText = webDriver.findElement(By.xpath("//span[contains(text(),'First name must be at least 2 characters long')]")).getText();
        Assert.assertTrue(expectedText.equals(actualText));
       // webDriver.quit();
    }

    @Then("^The message error is displayed for the Last Name name field$")
    public void theMessageErrorIsDisplayedForTheLastNameNameField() throws Throwable {
        String expectedText="Last name must be at least 2 characters long";
        String actualText = webDriver.findElement(By.xpath("//span[contains(text(),'Last name must be at least 2 characters long')]")).getText();
        Assert.assertTrue(expectedText.equals(actualText));
        //webDriver.quit();
    }
    @When("^The user go to the all owners page$")
    public void theUserGoToTheAllOwnersPage() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Owners']")).click();
        webDriver.findElement(By.xpath("//a[@routerlink='/owners']//span[contains(text(),'All')]")).click();
    }


    @And("^Check if a specific owner \"([^\"]*)\" has a pet$")
    public int checkIfASpecificOwnerHasAPet(String ownerName) throws Throwable {
      nameOwner=webDriver.findElements(By.xpath("//td//a"));
      int poz = -1;
        List<String> textList = new ArrayList<String>();
        for(WebElement we : nameOwner ) {
            textList.add(we.getText());
        }
        for (String l : textList) {
            if (l.equals(ownerName)) {
                poz = textList.indexOf(ownerName);
            }
        }
        return poz;


    }
    @Then("^Is displayed if the owner \"([^\"]*)\" has a pet$")
    public void isDisplayedIfTheOwnerHasAPet(String ownerName) throws Throwable {
        namePets=webDriver.findElements(By.xpath("//tbody//tr//td[5]"));
       //System.out.println(namePets.get(checkIfASpecificOwnerHasAPet(ownerName)).getText());
        Assert.assertNotEquals(namePets.get(checkIfASpecificOwnerHasAPet(ownerName)).getText(), "");
        webDriver.quit();
    }

}
