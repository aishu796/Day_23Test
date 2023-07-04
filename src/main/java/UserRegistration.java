
package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static void main(String[] args) {
        // User input values
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String mobileNumber = "91 9919819801";
        String password = "Passw0rd@";

        // First name validation
        String firstNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern firstNamePattern = Pattern.compile(firstNameRegex);
        Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
        boolean isFirstNameValid = firstNameMatcher.matches();

        // Last name validation
        String lastNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern lastNamePattern = Pattern.compile(lastNameRegex);
        Matcher lastNameMatcher = lastNamePattern.matcher(lastName);
        boolean isLastNameValid = lastNameMatcher.matches();

        // Email validation
        String emailRegex = "^[A-Za-z0-9]+([._%+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z]{2,}){1,2}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        boolean isEmailValid = emailMatcher.matches();

        // Mobile number validation
        String mobileRegex = "^[0-9]{2}\\s[0-9]{10}$";
        Pattern mobilePattern = Pattern.compile(mobileRegex);
        Matcher mobileMatcher = mobilePattern.matcher(mobileNumber);
        boolean isMobileValid = mobileMatcher.matches();

        // Password validation
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s)(?=^[^!@#$%^&*()-+=]+$).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        boolean isPasswordValid = passwordMatcher.matches();

        // Check if all fields are valid
        if (isFirstNameValid && isLastNameValid && isEmailValid && isMobileValid && isPasswordValid) {
            System.out.println("User registration is valid.");
        } else {
            System.out.println("User registration is invalid.");
        }
    }
}