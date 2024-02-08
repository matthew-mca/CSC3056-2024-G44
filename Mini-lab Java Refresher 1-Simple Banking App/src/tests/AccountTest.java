package tests;

import java.util.Date;
import model.Account;
import utils.TestUtils;

public class AccountTest {
    
    public static void main(String[] args) {
        testAccountConstructor();
    }

    public static void testAccountConstructor() {
        String testAccountNumber = "1234";
        String testAccountHolderUsername = "kmccomb12@qub.ac.uk";
        String testAccountType = "Savings";
        Date testAccountOpeningDate = new Date(896184000);

        // run the object under test
        Account testAccount = new Account(testAccountNumber, testAccountHolderUsername, testAccountType, testAccountOpeningDate);

        // Verify (Asset)
        //Testing testAccountNumber
        if (testAccount.getAccountNumber() == testAccountNumber)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccountNumber-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccountNumber-FAILED"+ TestUtils.TEXT_COLOR_RESET);
        
        //Testing testAccountHolderUsername
        if (testAccount.getAccountHolderUsername() == testAccountHolderUsername)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getAccountHolderUsername-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getAccountHolderUsername-FAILED"+ TestUtils.TEXT_COLOR_RESET);

        //Testing testAccountType
        if (testAccount.getAccountType() == testAccountType)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccountType-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccountType-FAILED"+ TestUtils.TEXT_COLOR_RESET);
        
        //Testing testAccountOpeningDate
        if (testAccount.getAccountOpeningDate() == testAccountOpeningDate)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getAccountOpeningDate-passed"+ TestUtils.TEXT_COLOR_RESET);
        else 
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getAccountOpeningDate-FAILED"+ TestUtils.TEXT_COLOR_RESET);
        
        // Using asserts
        assert testAccount.getAccountNumber() == testAccountNumber;
        assert testAccount.getAccountHolderUsername() == testAccountHolderUsername;
        assert testAccount.getAccountType() == testAccountType;
        assert testAccount.getAccountOpeningDate() == testAccountOpeningDate;

        System.out.println("All Java assertions in the test suite passed (none FAILED).");

        
    }
}

