import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.VacancyPage;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VacancyTest {

    @BeforeClass
    public void init2() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void vacancyEmptyTest() {
        MainPage mainPage = new MainPage();
        VacancyPage vacancyPage = mainPage.attendVacancyPage();
        boolean res = vacancyPage.pressButton();
        Assert.assertTrue(res);
    }

    @Test
    public void vacancyFullTest() {
        VacancyPage vacancyPage = new VacancyPage();
        boolean res = vacancyPage.fillForm();
        Assert.assertTrue(res);
    }
}
