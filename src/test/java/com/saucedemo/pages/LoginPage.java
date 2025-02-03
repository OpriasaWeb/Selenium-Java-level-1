package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("#login_button_container h3");

//    Setter method -------------------------------- //
    public void setUsername(String text){
        set(usernameField, text);
    }

    public void setPassword(String password){
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

//    Getter method -------------------------------- //
    public String getErrorMessage(){
        return find(errorMessage).getText();
    }

}
