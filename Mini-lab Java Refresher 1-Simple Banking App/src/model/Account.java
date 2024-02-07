package model;

import java.util.Date;

public class Account {
    private String accountNumber;
    private String accountHolderUsername;
    private String accountType;
    Date accountOpeningDate;

    public Account(String accountNumber, String accountHolderUsername, String accountType, Date accountOpeningDate) {
        this.accountNumber = accountNumber;
        this.accountHolderUsername = accountHolderUsername;
        this.accountType = accountType;
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderUsername() {
        return this.accountHolderUsername;
    }

    public void setAccountHolderUsername(String accountHolderUsername) {
        this.accountHolderUsername = accountHolderUsername;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getAccountOpeningDate() {
        return this.accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public String toString(){
        return this.accountNumber + ", " + this.accountHolderUsername + ", " + this.accountType + ", " + this.accountOpeningDate.toString();
    }
}
