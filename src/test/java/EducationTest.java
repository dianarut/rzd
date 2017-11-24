import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.EducationPage;
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.util.ConfigurationManager;
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
    public void educationEmptyTest() {
        MainPage mainPage = new MainPage();
        EducationPage educationPage = mainPage.attendEducationPage();
        int res = educationPage.pressButton();
        Assert.assertTrue(res > 0);
    }

    @Test(dependsOnMethods = {"educationEmptyTest"})
    public void educationFullTest() {
        EducationPage educationPage = new EducationPage();
        educationPage.fillForm();
        int res = educationPage.pressButton();
        Assert.assertTrue(res > 0);
    }

}
