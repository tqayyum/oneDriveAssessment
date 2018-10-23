package framework.page_object_model_web;

import framework.actions_web.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;

public class OneDriveLoginPage extends BasePage {

    private By iframe = By.xpath("//iframe[@class='SignIn']");
    private By email = By.xpath("//input[@type='email']");
    private By submit = By.xpath("//input[@type='submit']");
    private By password = By.xpath("//input[@type='password']");
    private By upload = By.xpath("//button[@name='Upload']");
    private By dropdown = By.xpath("//button[@name='Files']");
    private By zeroByte = By.xpath("//body[@id='RootPage.default.F.A']/input[2]");
    private By errorMsg = By.xpath("//div[@class='OperationMonitor-itemDescription']");
    private By successMsg = By.xpath("//div[@class='OperationMonitor-itemName']");
    private By clickOnFile = By.xpath("//div[@class='cellContent_4aa03851']");
    private By infoButton = By.xpath("(//button[@name='Details'])[2]");
    private By clickOnOpen = By.xpath("//button[@name='Open']");
    private By clickOpenInTextEditor = By.xpath("//button[@name='Open in Text Editor']");
    private By fileLines = By.xpath("//div[@class='view-lines']");
    private By fileLine = By.xpath("//div[@class='view-line'][2]/span/span");
    private By save = By.xpath("//button[@name='Save']");
    private By rightClickMenu = By.xpath("//span[contains(text(),'Delete')]");
    private By download = By.xpath("//button[@name='Download']");
    private By deleteMsg = By.xpath("//div[@class='OperationMonitor-itemName']");

    public void setEmail(String emailTxt) {
        switchToFrame(iframe);
        sendText(email, emailTxt);
        clickOn(submit);
    }

    public void setPassword(String passwordTxt) {
        sendText(password, passwordTxt);
        clickOn(submit);
    }

    public void clickOnUpload() { clickOn(upload);}

    public void setFileDropDown(String expectedTxt) {
        setDropDownValue(dropdown, expectedTxt);
    }

    public void setZeroByte(String expectedTxt) { sendText(zeroByte, expectedTxt); }

    public void getErrorMsg(String expectTxt) {compareText(errorMsg, expectTxt); }

    public void getSuccessMsg(String expectedTxt) { compareText(successMsg, expectedTxt); }

    public void clickOnFile() { clickOn(clickOnFile); }

    public void clickOnFileInfo() {clickOnAndWait(infoButton);}

    public void clickOnTxtEditor() throws InterruptedException{
        waitFor(5000);
        clickOn(clickOnOpen);
        waitFor(5000);
        clickOn(clickOpenInTextEditor);
    }

    public void setBodyText(String expectedTxt) {
        switchToWindow(1);
        clickOnAndWait(fileLines);
        clickOnAndWait(fileLine);
        //webAction(fileLine).clear();
        injectTxtWithJS(webAction(fileLine), expectedTxt);
        clickOn(save);
    }

    public void clickOnDownload() { clickOn(download);}

    public void rightClickOnFile() { rightClick(clickOnFile); }

    public void setDelete() {clickOn(rightClickMenu);}

    public void getDeleteMsg(String expectedTxt) { compareText(deleteMsg, expectedTxt); }

    public void verifyCompareFiles(String filePath1, String filePath2) throws IOException
    {compareFiles(filePath1, filePath2);}
}
