package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.page_object_model_web.OneDriveLoginPage;

import java.io.IOException;

public class OneDriveLoginSD {

    private OneDriveLoginPage oneDrive = new OneDriveLoginPage();

    @Given("^I am on one drive website homepage$")
    public void i_am_on_one_drive_website_homepage() { }

    @When("^I enter the email address as (.+)$")
    public void setEmailAddress(String emailTxt) { oneDrive.setEmail(emailTxt);}

    @And("^I enter the password as (.+)$")
    public void setPassword(String passwordTxt) { oneDrive.setPassword(passwordTxt);}

    @And("^I select Upload option$")
    public void clickOnUpload() { oneDrive.clickOnUpload();}

    @And("^I select (.+) from the drop down menu$")
    public void selectFiles(String expectedTxt) {oneDrive.setFileDropDown(expectedTxt);}

    @And("^I upload a (.+) file$")
    public void selectFile0(String expectedTxt) {oneDrive.setZeroByte(expectedTxt);}

    @And("^I click on the selected file$")
    public void clickOnFile() { oneDrive.clickOnFile(); }

    @And("^I click on the info button$")
    public void setInfoButton() { oneDrive.clickOnFileInfo(); }

    @And("^I select Open in Text Editor from the Open drop down menu$")
    public void clickOnTxtEditor() throws InterruptedException { oneDrive.clickOnTxtEditor();}

    @And("^I enter the follow text, (.+)$")
    public void setBodyText(String expectedTxt) { oneDrive.setBodyText(expectedTxt);}

    @And("^I click on the download link$")
    public void clickOnDownload() { oneDrive.clickOnDownload();}

    @And("^I right-click on the selected file$")
    public void rightClickOnFile() { oneDrive.rightClickOnFile(); }

    @And("^I select delete for the menu option")
    public void setDelete() { oneDrive.setDelete();}

    @Then("^I verify the following error message (.+)$")
    public void verifyFileUpload(String expectTxt){ oneDrive.getErrorMsg(expectTxt);}

    @Then("^I verify the following success massage (.+)$")
    public void verifySuccessfulFileUpload(String expectedTxt)  { oneDrive.getSuccessMsg(expectedTxt);}

    @Then("^I verify that(.+) file does not match (.+) file$")
    public void verifyUpdateVsSourceFile(String filePath1, String filePath2) throws IOException {oneDrive.verifyCompareFiles(filePath1, filePath2);}

    @Then("^I verify the delete message (.+)$")
    public void verifyDeleteMgs(String expectedTxt)  { oneDrive.getDeleteMsg(expectedTxt);}
}
