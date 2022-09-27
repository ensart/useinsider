package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UseInsiderPage {

    public UseInsiderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement cookieButton;

    @FindBy(xpath = "//span[normalize-space()='More']")
    public WebElement moreButton;

    @FindBy(xpath = "//h5[text()='Careers']")
    public WebElement careersButton;

    @FindBy(xpath = "//h3[normalize-space()='Find your calling']")
    public WebElement teamsWebElement;

    @FindBy(xpath = "//h3[@class='category-title-media ml-0']")
    public WebElement locationsWebElement;

    @FindBy(xpath = "//a[text()='See all teams']")
    public WebElement seeAllTeamsButton;

    @FindBy(xpath = "//h3[text()='Quality Assurance']")
    public WebElement quantityAssuranceButton;

    @FindBy(xpath = "//a[text()='See all QA jobs']")
    public WebElement seeAllQAJobsButton;

    @FindBy(id = "filter-by-location")
    public WebElement locationSelect1;

    @FindBy(xpath = "//*[text()='Software Quality Assurance Engineer']")
    public WebElement softQuaAssEng;

    @FindBy(xpath = "//*[@id='jobs-list']")
    public List<WebElement> jobList;

    @FindBy(xpath = "(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[2]")
    public WebElement applyButton;

    @FindBy(id = "filter-by-department")
    public WebElement departmentSelect;

    @FindBy(xpath = "//selection[@id=career-our-location]")
    public WebElement locationSelect2;

}
