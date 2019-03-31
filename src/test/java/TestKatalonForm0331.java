import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class TestKatalonForm0331 {

    WebDriver driver;
    String nameId = "firstName";
    String lastNameId = "lastName";
    // String genderId = "gender";
    String genderM = "/html/body/div/div/form/div[3]/div/div/label[1]/input";
    String genderF = "/html/body/div/div/form/div[3]/div/div/label[2]/input";
    String dobId = "dob";
    String addressId = "address";
    String emailId = "email";
    String passwordId = "password";
    String companyId = "company";
    String roleId = "role";
    String ways = "/html/body/div/div/form/div[11]/div/div[1]/label/input";
    String commentId = "comment";
    String submitId = "submit";
    String submitMsgId = "submit-msg";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testValidUserRegistration() {
        WebElement nameField = driver.findElement(By.name(nameId));


        if (nameField.isDisplayed()) {

            nameField.click();
            nameField.clear();
            nameField.sendKeys("John");
            System.out.println("Jest dostepny");

        } else {
            System.out.println("Nie Jest dostepny");
            Assert.fail();

        }


        WebElement lastNameField = driver.findElement(By.name(lastNameId));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Wayne");

//        WebElement gender = driver.findElement(By.name(genderId));
//        gender.click();

        WebElement genderFemale = driver.findElement(By.xpath(genderF));
        genderFemale.click();


        WebElement dobField = driver.findElement(By.name(dobId));
        dobField.click();
        dobField.clear();
        dobField.sendKeys("05/23/1907");


        WebElement addressField = driver.findElement(By.id(addressId));
        addressField.click();
        addressField.clear();
        addressField.sendKeys("Winterset, Iowa");

        WebElement emailField = driver.findElement(By.id(emailId));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("John.Wayne@john.jw");

        WebElement passwordField = driver.findElement(By.id(passwordId));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("12345");

        WebElement companyField = driver.findElement(By.id(companyId));
        companyField.click();
        companyField.clear();
        companyField.sendKeys("Western Company");


        Select select = new Select(driver.findElement(By.id(roleId)));
        select.selectByVisibleText("Manager");


        WebElement waysBox = driver.findElement(By.xpath(ways));
        waysBox.click();


        WebElement commentField = driver.findElement(By.id(commentId));
        commentField.click();
        commentField.clear();
        commentField.sendKeys("Ala ma kota");

        WebElement submitButton = driver.findElement(By.id(submitId));
        submitButton.click();

        WebElement checkSubmitMsg = driver.findElement(By.id(submitMsgId));
        assertTrue(checkSubmitMsg.isDisplayed());
    }


//@After
//    public void tearDown() throws InterruptedException {
//
//
//
////    driver.close();
//
//}

}
