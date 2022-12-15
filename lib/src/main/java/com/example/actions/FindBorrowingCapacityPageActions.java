package com.example.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.example.locators.FindBorrowingCapacityPageLocators;
import com.example.utils.HelperClass;
 
public class FindBorrowingCapacityPageActions {
 
    FindBorrowingCapacityPageLocators BorrowingCapacityPageLocators = null; 
     
    public FindBorrowingCapacityPageActions() {
 
        this.BorrowingCapacityPageLocators = new FindBorrowingCapacityPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),BorrowingCapacityPageLocators);
    }
     
    public void setApplicationType(String applicationType) {
    	
    	if(applicationType.trim().equals("single"))
    		BorrowingCapacityPageLocators.applicationTypeSingle.click();
    	else {
    	    System.out.println("Inside else block of application type");
    	    BorrowingCapacityPageLocators.applicationTypeJoint.click();
    	}	
    }
    
    public void enterAnnualIncome(String annualIncome) {
    	BorrowingCapacityPageLocators.annualIncome.click();
    	BorrowingCapacityPageLocators.annualIncome.sendKeys(annualIncome);
    	
    }
    
    public void setBorrowType(String borrowType) {
    	if(borrowType.trim().equals("home"))
    		BorrowingCapacityPageLocators.borrowTypeHome.click();
    	else
    		BorrowingCapacityPageLocators.borrowTypeInvestment.click();
    }
    
    public String getBorrowedAmount() {
    	return BorrowingCapacityPageLocators.borrowedAmount.getText();
    	
    }
     
    public void enterAnnualOtherIncome(String annualOtherIncome) {
    	BorrowingCapacityPageLocators.annualOtherIncome.click();
    	BorrowingCapacityPageLocators.annualOtherIncome.sendKeys(annualOtherIncome);
    }
    
    public void enterMonthlyLivingExpenses(String monthlyLivingExpenses) {
    	BorrowingCapacityPageLocators.monthlyLivingExpenses.click();
    	BorrowingCapacityPageLocators.monthlyLivingExpenses.sendKeys(monthlyLivingExpenses);
    }
    
    public void enterCurrentHomeLoanMonthlyRepayments(String currentHomeLoanMonthlyRepayments) {
    	BorrowingCapacityPageLocators.currentHomeLoanMonthlyRepayments.click();
    	BorrowingCapacityPageLocators.currentHomeLoanMonthlyRepayments.sendKeys(currentHomeLoanMonthlyRepayments);
    }
    
    public void enterOtherLoanMonthlyRepayments(String otherLoanMonthlyRepayments) {
    	BorrowingCapacityPageLocators.otherLoanMonthlyRepayments.click();
    	BorrowingCapacityPageLocators.otherLoanMonthlyRepayments.sendKeys(otherLoanMonthlyRepayments);
    }
    
    public void enterOtherMonthlyCommitments(String otherMonthlyCommitments) {
    	BorrowingCapacityPageLocators.otherMonthlyCommitments.click();
    	BorrowingCapacityPageLocators.otherMonthlyCommitments.sendKeys(otherMonthlyCommitments);
    }
    
    public void enterTotalCreditCardLimits(String totalCreditCardLimits) {
    	BorrowingCapacityPageLocators.totalCreditCardLimits.click();
    	BorrowingCapacityPageLocators.totalCreditCardLimits.sendKeys(totalCreditCardLimits);
    }
    
    public void selectNumberOfDependants(String number) {
    	Select numberOfDependants = new Select(BorrowingCapacityPageLocators.numberOfDependants);
    	numberOfDependants.selectByVisibleText(number);  	
    }
    
    public void clickButtonToCalculateBorrowingCapacity() {
    	BorrowingCapacityPageLocators.buttonToCalculateBorrowingCapacity.click();
    }
    
    public void clickButtonToStartOver() {
    	BorrowingCapacityPageLocators.buttonToStartOver.click();
    }
    
    public String valueOfField(String fieldName) {
    	String value = "Field is not blank";
    	if(fieldName.equals("Monthly Living Expenses")) {
    		return BorrowingCapacityPageLocators.monthlyLivingExpenses.getText(); //ideally this should be blank when "Start Over" gets clicked
    	} 
    	return value;
    }
    
}

