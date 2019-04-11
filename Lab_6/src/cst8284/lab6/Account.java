package cst8284.lab6;

import java.security.acl.LastOwnerException;

public class Account {
	private double startingBalance = 0; // cannot be negative or zero; throw error if negative
	private String accountNumber = "000-000000"; // cannot begin with 0, can be < 100000, must have branch number, must
	// have correct check digit
	private String firstName, lastName; // see below
	private OurDate accountOpenedDate; // use OurDate

	public Account() {
	}

	public OurDate getAccountOpenedDate() {
		return accountOpenedDate;
	}

	private void setAccountOpenedDate(OurDate od) {
		accountOpenedDate = od;
	}

	public Account(String accountNumber, String firstName, String lastName, String startDate) {
		setAccountNumber(accountNumber);
		setFirstName(firstName);
		setLastName(lastName);
		setAccountOpenedDate(new OurDate(startDate));
	}

	public double getBalance() {
		return startingBalance;
	}

	public String getAccountNumber() {
		
		return accountNumber;
	}

	private void setAccountNumber(String accountNumber) throws BadAccountInputException {	
		/*TODO #1: Bad account number entered.
		Test for presence of one hyphen in the account number.
		Error message to output: Only one hyphen allowed in account number.
		(3 marks)  */

		int j = 0;
		for(int i = 0; i <= accountNumber.length(); i++) {
			char c = (char)i;
			if (c == '-') {
				j++;
			}
		}

		if (j >= 2) {
			throw new BadAccountInputException("The account number cannot have more than one hyphen");
		}


		this.accountNumber = accountNumber;		
		//end method
	}

	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		if (isInputNameCorrect(firstName))
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		if (isInputNameCorrect(lastName))
			this.lastName = lastName;
	}

	private static boolean isInputNameCorrect(String name) throws BadAccountInputException {

		/*
		 * TODO #2: Bad name entered.
		 * 
		 * Test that the name does not contain numbers. Error message to output: Name
		 * contains a number; not allowed (3 marks)
		 */
	
		for(int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
				if (Character.isDigit(c)) {
					throw new BadAccountInputException("Names cannot contain numeric values");
			}

		}
		return true;
	}

	private static boolean isCheckDigitCorrect(String accountNumber) throws BadAccountInputException {
	
		/*
		 * TODO #3: Implement the following checksum algorithm and use it to trigger an
		 * exception if the account number is incorrect.
		 * 
		 * Write the code for a checksum algorithm that works as follow (assume account
		 * digits are numbered 123456, where the last digit, 6, is the check digit; the
		 * first five digits are the ones the algorithm applies to). Your code must work
		 * correctly with any six-digit account number according to the following
		 * algorithm. And it must also be scalable to any number of digits
		 *
		 * Description of algorithm: Multiply every succeeding odd digit by a power of
		 * 2, i.e. 2 times the first odd digit, 4 times the second, 8 times the third,
		 * etc. Sum the result and take modulus 7 Then check that this number equals the
		 * last (i.e. check) digit (5 marks)
		 *
		 */
		
		int[] odds = { 1, 3, 5, 7, 9 };
		int num = Integer.parseInt(accountNumber);
		int result = 0; // holds sum
		int count = 0; // holds the current count number
		for (int i = 0; i < accountNumber.length(); i++) {
			int k = 0; // holds succeeding value
			for (int j = 0; i < accountNumber.length(); j++)
				if (count == odds[j]) {
					result += odds[j];
					k++;
				} else if (k != 0) {
					result += 2 * odds[j];
				}
		} // end forloop
		for (int n = 0; n <= accountNumber.length(); n++) {
			num %= 10;
		}
		if ((result % 7) == num) {
			return true;
		} else {
			throw new BadAccountInputException("The account number is incorrect");
		}
	}

}
