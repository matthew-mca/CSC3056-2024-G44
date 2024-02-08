package tests;

import model.User;
import utils.TestUtils;

public class UserTest {
    public static void main(String[] args) {
        testUserConstructor();
    }

    public static void testUserConstructor() {
        String testUsername = "kmccomb12@qub.ac.uk";
        String testPassword = "Password";
        String testFirstName = "Kenton";
        String testLastName = "McComb";
        String testMobileNumber= "07712239587";

        // 2 run the object under test
        User testUser = new User(testUsername, testPassword, testFirstName, testLastName, testMobileNumber);

        // 3 Verify (Asset)
        //Testing username
        if (testUser.getUsername() == testUsername)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED"+ TestUtils.TEXT_COLOR_RESET);
        
        //Testing password
        if (testUser.getPassword() == testPassword)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-FAILED"+ TestUtils.TEXT_COLOR_RESET);

        //Testing firstName
        if (testUser.getFirstName() == testFirstName)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirstName-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirstName-FAILED"+ TestUtils.TEXT_COLOR_RESET);
        
        //Testing lastName
        if (testUser.getLastName() == testLastName)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLastName-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLastName-FAILED"+ TestUtils.TEXT_COLOR_RESET);
        
        //Testing MobileNumber
        if (testUser.getMobileNumber() == testMobileNumber)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobileNumber-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobileNumber-FAILED"+ TestUtils.TEXT_COLOR_RESET);

        // Using asserts
        assert testUser.getUsername() == testUsername;
        assert testUser.getPassword() == testPassword;
        assert testUser.getFirstName() == testFirstName;
        assert testUser.getLastName() == testLastName;
        assert testUser.getMobileNumber() == testMobileNumber;

        System.out.println("All Java assertions in the test suite passed (none FAILED).");

        
    }
}
