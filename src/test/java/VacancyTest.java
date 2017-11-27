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
    public void noFillingFormTest() {
        MainPage mainPage = new MainPage();
        VacancyPage vacancyPage = mainPage.attendVacancyPage();
        Assert.assertTrue(vacancyPage.pressButton());
    }

    @Test
    public void vacancyFullTest() {
        MainPage mainPage = new MainPage();
        VacancyPage vacancyPage = mainPage.attendVacancyPage();
        Assert.assertTrue(vacancyPage.fillForm());
    }
}
