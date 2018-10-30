package stepdefs;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddNewVet {
    WebDriver webDriver;
    List<WebElement> typevet;
    List<WebElement> checkVet;
    List<WebElement> checkEditButton;
    List<WebElement> checkDeleteButton;

    @Given("^The user accesses the petclinic site$")
    public void theUserAccessesThePetclinicSite() throws Throwable {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        //webDriver.get("http://j3r3my.mywire.org:81/petclinic/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @When("^The user goes to the page of adding a new vet$")
    public void theUserGoesToThePageOfAddingANewVet() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Veterinarians']")).click();
        webDriver.findElement(By.xpath("(//span[text()=' Add New'])[2]")).click();
    }


    @And("^The user enters the first name field \"([^\"]*)\" in the last name field \"([^\"]*)\" and chooses as type \"([^\"]*)\"$")
    public void theUserEntersTheFirstNameFieldInTheLastNameFieldAndChoosesAsType(String firstName, String lastName, String type) throws Throwable {
        webDriver.findElement(By.id("firstName")).sendKeys(firstName);
        webDriver.findElement(By.id("lastName")).sendKeys(lastName);
        webDriver.findElement(By.id("specialties")).click();
        typevet = webDriver.findElements(By.xpath("//option"));
        int poz =-1;

        List<String> textList = new ArrayList<String>();
        for(WebElement we : typevet ) {
            textList.add(we.getText().trim());
        }
        System.out.println(textList);
        for (String l : textList) {
            if (l.equals(type)) {
                poz = textList.indexOf(type);
            }
        }
        if (poz!=-1) typevet.get(poz).click();
    }

    @Then("^The user clicks the Save Vet button$")
    public void theUserClicksTheSaveVetButton() throws Throwable {
        webDriver.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).click();
    }

    @And("^The user checks if the new vet \"([^\"]*)\" has been added$")
    public void theUserChecksIfTheNewVetHasBeenAdded(String VetName) throws Throwable {
        checkVet = webDriver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<String> textList = new ArrayList<String>();
        int poz = -1;
        for (WebElement we : checkVet) {
            textList.add(we.getText());

        }
        for (String l : textList) {
            if (l.equals(VetName)) {
                poz = textList.indexOf(VetName);
            }
        }
        Assert.assertNotEquals(poz,-1);
        //webDriver.quit();
    }


    @Then("^The error message is displayed for first name field$")
    public void theErrorMessageIsDisplayedForFirstNameField() throws Throwable {
        String expectedText="First name must be at least 2 characters long";
        String actualText = webDriver.findElement(By.xpath("//span[@class='help-block']")).getText();
        Assert.assertTrue(expectedText.equals(actualText));
        webDriver.quit();
    }

    @Then("^The error message is displayed for last name field$")
    public void theErrorMessageIsDisplayedForLastNameField() throws Throwable {
        String expectedText = "Last name must be at least 2 characters long";
        String actualText = webDriver.findElement(By.xpath("//span[@class='help-block']")).getText();
        Assert.assertTrue(expectedText.equals(actualText));
        webDriver.quit();
    }

    @And("^The user click on the Save Vet button$")
    public void theUserClickOnTheSaveVetButton() throws Throwable {
        webDriver.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).click();
    }

    @Then("^The user remains on the add-on page of the new vet because nothing happens$")
    public void theUserRemainsOnTheAddOnPageOfTheNewVetBecauseNothingHappens() throws Throwable {
        Assert.assertTrue(webDriver.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).isDisplayed());
        webDriver.quit();
    }




    @And("^The user clicks on the edit button for \"([^\"]*)\"$")
    public void theUserClicksOnTheEditButtonFor(String vetName) throws Throwable {
        checkVet = webDriver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<String> textList = new ArrayList<String>();
        int poz = -1;
        for (WebElement we : checkVet) {
            textList.add(we.getText());

        }
        for (String l : textList) {
            if (l.equals(vetName)) {
                poz = textList.indexOf(vetName);
            }
        }
        System.out.println(poz);
        checkEditButton = webDriver.findElements(By.xpath("//button[contains(text(),'Edit')]"));
       checkEditButton.get(poz).click();
    }

    @And("^The user edit the new vet with \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void theUserEditTheNewVetWithAnd(String fistName, String lastname, String type) throws Throwable {
        webDriver.findElement(By.xpath("//input[contains(@id,'firstName')]")).clear();
        webDriver.findElement(By.xpath("//input[contains(@id,'firstName')]")).sendKeys(fistName);
        webDriver.findElement(By.xpath("//input[contains(@id,'lastName')]")).clear();
        webDriver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys(lastname);

        webDriver.findElement(By.xpath(" //div[@class='mat-select-arrow-wrapper']")).click();
        typevet = webDriver.findElements(By.xpath("//mat-option"));
        int poz =-1;

        List<String> textList = new ArrayList<String>();
        for(WebElement we : typevet ) {
            textList.add(we.getText().trim());
        }
        System.out.println(textList);
        for (String l : textList) {
            if (l.equals(type)) {
                poz = textList.indexOf(type);
            }
        }
        if (poz!=-1) typevet.get(poz).click();
    }


    @And("^The user clicks the Save Vet button for update$")
    public void theUserClicksTheSaveVetButtonForUpdate() throws Throwable {

        webDriver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.ESCAPE);
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("^The user can click on the delete button for new vet with name \"([^\"]*)\"$")
    public void theUserCanClickOnTheDeleteButtonForNewVetWithName(String vetName) throws Throwable {
        checkDeleteButton = webDriver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
        checkVet = webDriver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<String> textList = new ArrayList<String>();
        int poz = -1;
        for (WebElement we : checkVet) {
            textList.add(we.getText());

        }
        for (String l : textList) {
            if (l.equals(vetName)) {
                poz = textList.indexOf(vetName);
            }
        }
        checkDeleteButton.get(poz).isEnabled();
        webDriver.quit();
    }


    @When("^The user goes to the page of adding all vets$")
    public void theUserGoesToThePageOfAddingAllVets() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Veterinarians']")).click();
        webDriver.findElement(By.xpath("(//span[contains(text(),'All')])[2]")).click();

    }
}
