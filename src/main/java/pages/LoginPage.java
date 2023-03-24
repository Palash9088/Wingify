package pages;//import java.util.*;

import base.PredefinedActions;
import constants.ConstantPaths;
import utils.PropertyReading;

import java.util.ArrayList;

public class LoginPage extends PredefinedActions {

    private static LoginPage loginPage;
    private static PropertyReading loginPageProp,configProp;

    private LoginPage() {
        loginPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "LoginPageProp.properties");
        configProp = new PropertyReading(ConstantPaths.CONFIG_PATH);
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null)
            loginPage = new LoginPage();
        return loginPage;
    }

    public ArrayList<String> getCred() {
        ArrayList<String> credList = new ArrayList<>();
        credList.add(configProp.getValue("userName"));
        credList.add(configProp.getValue("passWord"));
        return credList;
    }

    public String getLoginPageText() {
        return getElementText(getElement(loginPageProp.getValue("header"), true)).trim();
    }

    public String getUrl() {
        return getCurrentWebpageUrl();
    }

    public boolean isUsernameFieldEnabled() {
        return isFieldEnabled(loginPageProp.getValue("usernameField"), true);
    }

    public boolean isPasswordFieldEnabled() {
        return isFieldEnabled(loginPageProp.getValue("passwordField"), false);
    }

    public String getUsernamePlaceholder() {
        return getAttribute(getElement(loginPageProp.getValue("usernameField"), true), "placeholder");
    }

    public String getPasswordPlaceholder() {
        return getAttribute(getElement(loginPageProp.getValue("passwordField"), true), "placeholder");

    }

    public String getErrorMsg() {
        return getElementText(getElement(loginPageProp.getValue("errorText"), true));
    }

    public boolean clickOnRememberMe() {
        clickOnElement(loginPageProp.getValue("rememberMeBtn"), true);
        return isElementSelected(loginPageProp.getValue("rememberMeBtn"), true);
    }

    public String getUsername() {
        return getAttribute(getElement(loginPageProp.getValue("usernameField"), true), "value");
    }
    public void enterCredentials(String username, String password) {
        enterText(getElement(loginPageProp.getValue("usernameField"), true), username);
        enterText(getElement(loginPageProp.getValue("passwordField"), false), password);
    }

    public void clickOnLoginBtn() {
        clickOnElement(loginPageProp.getValue("loginBtn"), true);
    }

}
