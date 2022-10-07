package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProjectsPage.class.getName());
    @FindBy(id = "createButton")
    private WebElement createNewButton;
    @FindBy(xpath = "//div[contains(@id, 'application-content')]//a[contains(@class, 'defect-title')]")
    private WebElement selectionProject;
    @FindBy(xpath = "//div[contains(@id, 'application-content')]//a[text() = 'ShareLane']")
    private WebElement selectionShareLaneProject;

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Awaiting field Project Name")
    public boolean createButtonIsDisplayed() {
        LOGGER.debug(String.format("Check button: %s", createNewButton.getText()));
        boolean createButton = createNewButton.isDisplayed();
        return createButton;
    }

    @Step("Click Create New Project Button")
    public void clickCreateButton() {
        LOGGER.debug(String.format("Click create new project button: %s", createNewButton.getText()));
        createNewButton.click();
    }

    @Step("Selection Project")
    public void clickProject() {
        LOGGER.debug(String.format("Click : %s", selectionProject.getText()));
        selectionProject.click();

    }

    @Step("Selection Project SHARELANE")
    public void clickProjectSharelane() {
        LOGGER.debug(String.format("Click : %s", selectionShareLaneProject.getText()));
        selectionShareLaneProject.click();
    }
}