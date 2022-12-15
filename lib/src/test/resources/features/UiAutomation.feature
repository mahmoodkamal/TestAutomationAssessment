Feature: Calculate borrowing capacity
Background:
Given User is on Calculator page "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow"

@UIautomation
Scenario: Calculate borrowing capacity for a person who is single

When User enters application Type as "<applicationType>" and annual income as "<annualIncome>" and borrow type as "<borrowType>" and annual other income as "<annualOtherIncome>" and monthly living expenses as "<monthlyLivingExpenses>" and current home monthly repayment as "<currenthomeLoanMonthlyRepayment>" and other loan monthly repayment as "<otherLoanMonthlyRepayment>" and other monthly commitment as "<otherMonthlyCommitment>" and total credit card limit as "<totalCreditCardLimit>" and number of dependants as "<numberOfDependants>"
Then Borrowing Capacity is "<borrowingCapacity>"

When User clicks Start Over
Then Fields get reset

Examples:
	| applicationType | annualIncome | borrowType |annualOtherIncome| monthlyLivingExpenses | currenthomeLoanMonthlyRepayment | otherLoanMonthlyRepayment | otherMonthlyCommitment | totalCreditCardLimit | numberOfDependants |borrowingCapacity |
	| single          | $80000       | home       |      $10000     |    $500               |           $0                    |         $100              |       $0               |        $10000        |         0          |   $447,000       |