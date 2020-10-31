package objectrepository;

import org.openqa.selenium.By;

public class UILocators {

    // userName input text on Login page
    public static final By userName = By.id("username");

    // password input text on Login page
    public static final By password = By.id("password");

    // Login Button on Login page
    public static final By loginButton = By.className("radius");

    // Message on Login Page
    public static final By message = By.id("flash");

    // Logout Button on Login page
    public static final By logoutButton = By.className("secondary");

    // Close button on exit intent
    public static final By closeButton = By.xpath("//*[@id='ouibounce-modal']/div[2]/div[3]");

    // Last Name on table page
    public static final By lastName = By.xpath("//*[@id='table1']/thead/tr/th[1]/span");

    // First Name on table page
    public static final By firstName = By.xpath("//*[@id='table1']/thead/tr/th[2]/span");

    // Table 1 on table page
    public static final By tableOne = By.xpath("//*[@id='table1']/tbody/tr");

    // Table 2 on table page
    public static final By tableTwo = By.xpath("//*[@id='table2']/tbody/tr");

    // Example 1 on table page
    public static final By exampleOne = By.xpath("//*[@id='content']/div/h4[1]");

    // Example 2 on table page
    public static final By exampleTwo = By.xpath("//*[@id='content']/div/h4[2]");

    // Click here button on window page
    public static final By clickHereButton = By.xpath("//*[@id='content']/div/a");

    // New Window Text on new window page
    public static final By newWindowText = By.className("example");

    // Swap button on dynamic control page
    public static final By swapButton = By.xpath("//*[@id='input-example']/button");

    // Input Example text on dynamic control page
    public static final By inputExample = By.xpath("//*[@id='input-example']/input");

    // Message on dynamic control page
    public static final By messageDynamic = By.id("message");
}
