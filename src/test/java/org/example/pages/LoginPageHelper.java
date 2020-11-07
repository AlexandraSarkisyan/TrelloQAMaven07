package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement loginField;

    @FindBy(id = "error")
    WebElement errorMessage;

    @FindBy(id = "login-error")
    WebElement errorMessageAtl;

    @FindBy(xpath = "//input[@value='Log in with Atlassian']")
    WebElement loginButtonAtl;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//button[@data-test-id ='header-boards-menu-button']")
    WebElement boardsButton;

    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver= driver;
    }
    public LoginPageHelper loginAsAtlassian(String login,String password) {
        log4j.info("LoginPageHelper:loginAsAtlassian(login = "+login+",password="+password+")");
        log4j.info("****************** Enter Atlassian login ****************** ");
        enterLogin(login);
        submitAsAtlassian();
        log4j.info("****************** Enter Atlassian password ****************** ");
        enterPasswordAsAtlassian(password);

        return this;
    }
    public String getBoardsIconName(){
        return boardsButton.getText();
    }
    public LoginPageHelper enterPasswordAsAtlassian(String password) {
        log4j.info("****************** LoginPageHelper:enterPasswordAsAtlassian(password="+password+") ****************** ");
        log4j.info("****************** Enter Atlassian password ****************** ");
        editField(passwordField,password);
        waitUntilElementIsClickable(loginSubmitButton,10);
        log4j.info("****************** Submit password ****************** ");
        loginSubmitButton.click();
        return this;
    }
    public LoginPageHelper loginNotAtlassian(String login,String password) {
        log4j.info("****************** LoginPageHelper:loginNotAtlassian(login = "+login+",password="+password+")");
        log4j.info("****************** Enter login ****************** ");
        enterLogin(login);
        log4j.info("****************** Enter not Atlassian password ****************** ");
        enterNotAttlassianPassword(password);
        log4j.info("****************** Submit password ****************** ");
        pressLoginButton();
        waitUntilElementIsVisible(errorMessage,10);
        return this;
    }
    public LoginPageHelper submitAsAtlassian() {
        log4j.info("****************** Submit as Atlassian ***********************");
        waitUntilElementIsClickable(loginButtonAtl,10);
        loginButtonAtl.click();
        waitUntilElementIsClickable(passwordField,10);
        return this;
    }

    public LoginPageHelper enterLogin(String login) {
        editField(loginField,login);
        return this;
    }

    public LoginPageHelper waitUntilLoginPageIsLoaded(){
       waitUntilElementIsClickable(loginField,10);
        return this;
    }
    public String getErrorMessage(){
        waitUntilElementIsVisible(errorMessage, 10);
        return errorMessage.getText();
    }

    public String getAtlassianErrorMessage(){
        waitUntilElementIsVisible(errorMessageAtl, 10);
        return errorMessageAtl.getText();
    }
    public LoginPageHelper enterNotAttlassianPassword(String password) {
        //Enter existent password
        editField(passwordField,password);
        return this;
    }
    public LoginPageHelper pressLoginButton() {
        //waitUntilElementIsClickable(loginButton,10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        return this;
    }

}
