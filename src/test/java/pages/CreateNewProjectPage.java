package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.PrepareCreateNewProjectData;

import java.util.concurrent.TimeUnit;

public class CreateNewProjectPage extends BasePage {

    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LogManager.getLogger(CreateNewProjectPage.class.getName());
    @FindBy(id = "project-name")
    private WebElement projectNameField;
    @FindBy(id = "description-area")
    private WebElement descriptionNewProjectField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement createProjectButton;

    @Step("Awaiting field Project Name")
    public void awaitProjectNameField() {
        LOGGER.debug(String.format("Await %s", projectNameField));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("project-name")));
    }

    @Step("Input Data for New Project")
    public void createNewProject() throws InterruptedException {
        awaitProjectNameField();
        Thread.sleep(4000);
        LOGGER.debug(String.format("Input project Name %s", PrepareCreateNewProjectData.getCreateProjectData().getProjectName()));
        projectNameField.sendKeys(PrepareCreateNewProjectData.getCreateProjectData().getProjectName());
        LOGGER.debug(String.format("Input description field %s", PrepareCreateNewProjectData.getCreateProjectData().getDescription()));
        descriptionNewProjectField.sendKeys(PrepareCreateNewProjectData.getCreateProjectData().getDescription());
        LOGGER.info("Click Create project button");
        createProjectButton.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
}