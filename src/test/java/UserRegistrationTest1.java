import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class UserRegistrationTest1 {

    @Test
    public void testFirstNameValidation() {
        assertThrows(InvalidFirstNameException.class, () -> validateField("", UserRegistration::isValidFirstName));
        assertThrows(InvalidFirstNameException.class, () -> validateField("j", UserRegistration::isValidFirstName));
        assertThrows(InvalidFirstNameException.class, () -> validateField("john", UserRegistration::isValidFirstName));
        assertDoesNotThrow(() -> validateField("John", UserRegistration::isValidFirstName));
    }

    @Test
    public void testLastNameValidation() {
        assertThrows(InvalidLastNameException.class, () -> validateField("", UserRegistration::isValidLastName));
        assertThrows(InvalidLastNameException.class, () -> validateField("D", UserRegistration::isValidLastName));
        assertThrows(InvalidLastNameException.class, () -> validateField("Doe", UserRegistration::isValidLastName));
        assertDoesNotThrow(() -> validateField("JohnDoe", UserRegistration::isValidLastName));
    }

    @Test
    public void testEmailValidation() {
        assertThrows(InvalidEmailException.class, () -> validateField("", UserRegistration::isValidEmail));
        assertThrows(InvalidEmailException.class, () -> validateField("john.doe@example", UserRegistration::isValidEmail));
        assertThrows(InvalidEmailException.class, () -> validateField("john.doe@example.", UserRegistration::isValidEmail));
        assertDoesNotThrow(() -> validateField("john.doe@example.com", UserRegistration::isValidEmail));
    }

    @Test
    public void testMobileValidation() {
        assertThrows(InvalidMobileException.class, () -> validateField("", UserRegistration::isValidMobile));
        assertThrows(InvalidMobileException.class, () -> validateField("12345", UserRegistration::isValidMobile));
        assertThrows(InvalidMobileException.class, () -> validateField("91 991981980", UserRegistration::isValidMobile));
        assertDoesNotThrow(() -> validateField("91 9919819801", UserRegistration::isValidMobile));
    }

    @Test
    public void testPasswordValidation() {
        assertThrows(InvalidPasswordException.class, () -> validateField("", UserRegistration::isValidPassword));
        assertThrows(InvalidPasswordException.class, () -> validateField("password", UserRegistration::isValidPassword));
        assertThrows(InvalidPasswordException.class, () -> validateField("Password1", UserRegistration::isValidPassword));
        assertDoesNotThrow(() -> validateField("Password@123", UserRegistration::isValidPassword));
    }

    private <T> void assertThrows(Class<? extends Exception> expectedType, Executable executable) {
        try {
            executable.execute();
            Assert.fail("Expected exception " + expectedType.getSimpleName() + " not thrown");
        } catch (Exception e) {
            Assert.assertEquals(expectedType, e.getClass());
        }
    }

    private <T> void assertDoesNotThrow(Executable executable) {
        try {
            executable.execute();
        } catch (Exception e) {
            Assert.fail("Unexpected exception " + e.getClass().getSimpleName() + " thrown");
        }
    }

    private void validateField(String input, Predicate<String> validationFunction) throws Exception {
        if (!validationFunction.test(input)) {
            throw getExceptionForValidation(validationFunction);
        }
    }

    private Exception getExceptionForValidation(Predicate<String> validationFunction) {
        if (validationFunction == UserRegistration::isValidFirstName) {
            return new InvalidFirstNameException("Invalid first name");
        } else if (validationFunction == UserRegistration::isValidLastName) {
            return new InvalidLastNameException("Invalid last name");
        } else if (validationFunction == UserRegistration::isValidEmail) {
            return new InvalidEmailException("Invalid email");
        } else if (validationFunction == UserRegistration::isValidMobile) {
            return new InvalidMobileException("Invalid mobile number");
        } else if (validationFunction == UserRegistration::isValidPassword) {
            return new InvalidPasswordException("Invalid password");
        } else {
            return new Exception("Invalid validation function");
        }
    }
}