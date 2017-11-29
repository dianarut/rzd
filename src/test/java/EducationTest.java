import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.EducationPage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EducationTest {

    @BeforeClass
    public void init2() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void noFillingFormTest() {
        MainPage mainPage = new MainPage();
        EducationPage educationPage = mainPage.attendEducationPage();
        Assert.assertFalse(educationPage.pressButton());
    }

    @Test()
    public void fillNameSpecializationCityTest() {
        MainPage mainPage = new MainPage();
        EducationPage educationPage = mainPage.attendEducationPage();
        educationPage.fillForm();
        Assert.assertFalse(educationPage.pressButton());
    }
}
