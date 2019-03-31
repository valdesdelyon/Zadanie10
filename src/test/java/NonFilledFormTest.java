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

public class NonFilledFormTest {

    WebDriver driver;

    String submitId = "submit";
    String firstNameErrorId = "first-name-error";
    String lastNameErrorId = "last-name-error";
    String genderErrorId = "gender-error";
    String dobErrorId = "dob-error";
    String addressErrorId = "address-error";
    String emailErrorId = "email-error";
    String passwordErrorId = "password-error";
    String companyErrorId = "company-error";


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
    public void testValid() {
        WebElement submitButton = driver.findElement(By.id(submitId));
        submitButton.click();

        WebElement checkFirstName = driver.findElement(By.id(firstNameErrorId));
        assertTrue(checkFirstName.isDisplayed());

        WebElement checkLastName = driver.findElement(By.id(lastNameErrorId));
        assertTrue(checkLastName.isDisplayed());

        WebElement checkGender = driver.findElement(By.id(genderErrorId));
        assertTrue(checkGender.isDisplayed());

        WebElement checkDob = driver.findElement(By.id(dobErrorId));
        assertTrue(checkDob.isDisplayed());

        WebElement checkAddress = driver.findElement(By.id(addressErrorId));
        assertTrue(checkAddress.isDisplayed());

        WebElement checkEmail = driver.findElement(By.id(emailErrorId));
        assertTrue(checkEmail.isDisplayed());


        WebElement checkPassword = driver.findElement(By.id(passwordErrorId));
        assertTrue(checkPassword.isDisplayed());


        WebElement checkCompany = driver.findElement(By.id(companyErrorId));
        assertTrue(checkCompany.isDisplayed());


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