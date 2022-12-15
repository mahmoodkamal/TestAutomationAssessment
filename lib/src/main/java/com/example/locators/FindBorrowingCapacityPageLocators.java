package com.example.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class FindBorrowingCapacityPageLocators {
	@FindBy(css = "label[for='application_type_single']")
    public WebElement applicationTypeSingle;
	
	@FindBy(css = "label[for='application_type_joint']")
    public WebElement applicationTypeJoint;
	
	@FindBy(id = "borrowResultTextAmount")
	public WebElement borrowedAmount;
	
	@FindBy(css = "label[for='borrow_type_home']")
	public WebElement borrowTypeHome;
	
	@FindBy(css = "label[for='borrow_type_investment']")
	public WebElement borrowTypeInvestment;
	
	@FindBy(css = "input[aria-labelledby=q2q1]")
	public WebElement annualIncome;
	
	@FindBy(css = "input[aria-labelledby=q2q2]")
	public WebElement annualOtherIncome;
	
	@FindBy(css = "input[aria-labelledby=q3q1]")
	public WebElement monthlyLivingExpenses;
	
	@FindBy(css = "input[aria-labelledby=q3q2]")
	public WebElement currentHomeLoanMonthlyRepayments;
	
	@FindBy(css = "input[aria-labelledby=q3q3]")
	public WebElement otherLoanMonthlyRepayments;
	
	@FindBy(css = "input[aria-labelledby=q3q4]")
	public WebElement otherMonthlyCommitments;
	
	@FindBy(css = "input[aria-labelledby=q3q5]")
	public WebElement totalCreditCardLimits;
	
	@FindBy(css = "select[title='Number of dependants']")
	public WebElement numberOfDependants;
	
	@FindBy(id = "btnBorrowCalculater")
	public WebElement buttonToCalculateBorrowingCapacity;
	
	@FindBy(css = "button[class=start-over]")
	public WebElement buttonToStartOver;
		  
}
