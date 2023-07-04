import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserRegistrationTest {
    private String input;
    private boolean expectedResult;

    public UserRegistrationTest(String input, boolean expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    // Happy test cases for first name
    @Test
    public void testFirstNameHappy() {
        String firstName = "John";
        boolean isValid = UserRegistration.validateFirstName(firstName);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Sad test cases for first name
    @Test
    public void testFirstNameSad() {
        String firstName = input;
        boolean isValid = UserRegistration.validateFirstName(firstName);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Happy test cases for last name
    @Test
    public void testLastNameHappy() {
        String lastName = "Doe";
        boolean isValid = UserRegistration.validateLastName(lastName);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Sad test cases for last name
    @Test
    public void testLastNameSad() {
        String lastName = input;
        boolean isValid = UserRegistration.validateLastName(lastName);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Happy test cases for email
    @Test
    public void testEmailHappy() {
        String email = "johndoe@example.com";
        boolean isValid = UserRegistration.validateEmail(email);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Sad test cases for email
    @Test
    public void testEmailSad() {
        String email = input;
        boolean isValid = UserRegistration.validateEmail(email);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Happy test cases for mobile number
    @Test
    public void testMobileHappy() {
        String mobileNumber = "91 9919819801";
        boolean isValid = UserRegistration.validateMobileNumber(mobileNumber);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Sad test cases for mobile number
    @Test
    public void testMobileSad() {
        String mobileNumber = input;
        boolean isValid = UserRegistration.validateMobileNumber(mobileNumber);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Happy test cases for password
    @Test
    public void testPasswordHappy() {
        String password = "Passw0rd@";
        boolean isValid = UserRegistration.validatePassword(password);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Sad test cases for password
    @Test
    public void testPasswordSad() {
        String password = input;
        boolean isValid = UserRegistration.validatePassword(password);
        Assert.assertEquals(expectedResult, isValid);
    }

    // Parameterized test for email addresses
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abc.xyz@bl.co.in", true},
                {"john.doe@example.com", true},
                {"test@domain.com", true},
                {"invalidemail", false},
                {"abc@domain", false},
                {"email@.com", false}
        });
    }

    @Test
    public void testEmailParameterized() {
        String email = input;
        boolean isValid = UserRegistration.validateEmail(email);
        Assert.assertEquals(expectedResult, isValid);
    }
}
