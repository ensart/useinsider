package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.UseInsiderPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;
import java.util.Set;


public class UiTest extends TestBaseRapor {
    /*
1. Visit https://useinsider.com/ and check Insider home page is opened or not
2. Select “More” menu in navigation bar, select “Careers” and check Career page, its
Locations, Teams and Life at Insider blocks are opened or not
3. Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
Location - Istanbul, Turkey and department - Quality Assurance, check presence of
jobs list
4. Check that all jobs’ Position contains “Quality Assurance”, Department contains
“Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button
5. Click “Apply Now” button and check that this action redirects us to Lever Application
form page
*/

    @Test
    public void test() throws InterruptedException {
        extentTest = extentReports.createTest("UseInsider UI Test", "Task01");
        Driver.getDriver().get(ConfigReader.getProperty("useInsiderURL"));
        extentTest.info("https://useinsider.com/ sayfasina gidildi");
        UseInsiderPage useInsiderPage = new UseInsiderPage();
        useInsiderPage.cookieButton.click();
        useInsiderPage.moreButton.click();
        useInsiderPage.careersButton.click();
        Assert.assertTrue(useInsiderPage.teamsWebElement.isDisplayed());
        extentTest.pass("Teams Webelementi goruldu");
        Assert.assertTrue(useInsiderPage.locationsWebElement.isDisplayed());
        extentTest.pass("Locations Webelementi goruldu");


        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click()", useInsiderPage.seeAllTeamsButton);
        jse.executeScript("arguments[0].click()", useInsiderPage.quantityAssuranceButton);
        jse.executeScript("arguments[0].click()", useInsiderPage.seeAllQAJobsButton);


        Select locationsSelect = new Select(useInsiderPage.locationSelect1);
        locationsSelect.selectByVisibleText("Istanbul, Turkey");
        extentTest.info("Istanbul, Turkey secildi");
        List<WebElement> locationsSelectElement = locationsSelect.getOptions();
        int locationControl = 0;
        for (WebElement each : locationsSelectElement) {
            if (each.getText().equals("Istanbul, Turkey"))
                locationControl = 1;
        }
        Assert.assertEquals(locationControl, 1, "Istanbul, Turkey  degeri yok");
        extentTest.pass("Location dorp down da Istanbul, Turkey var");


        Select departmentSelect = new Select(useInsiderPage.departmentSelect);
        List<WebElement> departmentSelectElement = departmentSelect.getOptions();
        int departmentControl = 0;
        for (WebElement each : departmentSelectElement) {
            if (each.getText().equals("Quality Assurance"))
                departmentControl = 1;
        }
        Assert.assertEquals(departmentControl, 1, "Quality Assurance degeri yok");
        extentTest.pass("Department dorp down da Quality Assurance degeri var");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        actions.moveToElement(useInsiderPage.applyButton).perform();
        Assert.assertTrue(useInsiderPage.applyButton.isDisplayed());
        extentTest.pass("Apply butonu goruldu");
        useInsiderPage.applyButton.click();


        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        String newWindowHandles = "";
        for (String each : windowHandles) {
            if (each != Driver.getDriver().getWindowHandle())
                newWindowHandles = each;
        }
        Driver.getDriver().switchTo().window(newWindowHandles);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://jobs.lever.co/useinsider"));
        extentTest.pass("Lever Application sayfasina gecildi");

    }

}
