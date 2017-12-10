package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.BasicScheduleLDTrainsResultsPage;
import ru.rzd.pageobjects.BasicSchedulePage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.util.ConfigurationManager;

import static ru.rzd.util.AssertManager.isElementDisplayed;

public class BaseScheduleOfLongDistanceTrainsTest{
    private static final String FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String TO = ConfigurationManager.getProperty("movement.base.to");

    @Given("^the user is on Passengers Main Page$")
    public void getPassengersMainPage() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(ConfigurationManager.getProperty("driver.start"));
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
    }

    @When("^he go to Base Schedule? Of Long Distance Trains? Page$")
    public void getPassengerMainPage() {
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        passengerMainPage.clickBasicScheduleTab();
    }

    @And("^he fill out the form? with (.+) and (.+)$")
    public void fillOutTheForm(String from, String to) {
        BasicSchedulePage basicSchedulePage = new BasicSchedulePage();
        basicSchedulePage.fillForm(from, to);
    }

    @And("^he choose some date$")
    public void chooseSomeDate() {
        BasicScheduleLDTrainsResultsPage basicScheduleLDTrainsResultsPage = new BasicScheduleLDTrainsResultsPage();
        basicScheduleLDTrainsResultsPage.clickSomeDate();
    }
    @Then("^ensure an information message about trip?$")
    public void ensureAnInformationMessage() {
        BasicScheduleLDTrainsResultsPage basicScheduleLDTrainsResultsPage = new BasicScheduleLDTrainsResultsPage();
        Assert.assertTrue(isElementDisplayed(basicScheduleLDTrainsResultsPage.getInformationMessage()), "The information message about route is not found!");
    }
}
