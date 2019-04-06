package cst8284.lab6;

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

	private void setAccountNumber(String accountNumber) {	
		/*TODO #1: Bad account number entered.
		Test for presence of one hyphen in the account number.
		Error message to output: Only one hyphen allowed in account number.
		(3 marks)  */
		//TODO #1: Run the 'Lab 6 TODO generator.jar' file and follow the instructions.
		// Write the code here to test for the error condition indicated
		// when the user attempts to enter a bad account number, and throw
		// a BadAccountInputException containing the message provided.
		// Only if there is no error should the account number be set.


		try {

			int j;
			for(int i = 0; i <= accountNumber.length(); i++) {
				char c = (char)i;
				if (c == '-') {
					j++;
				}
			}
			if (j != 1) {
				throw new BadAccountInputException;
			}
		} catch (BadAccountInputException e) {
			System.out.println("Only one hyphen allowed in account number");
			
		} // End Catch block
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

	private static boolean isInputNameCorrect(String name) {
		/*
		 * TODO #2: Bad name entered.
		 * 
		 * Test that the name does not contain numbers. Error message to output: Name
		 * contains a number; not allowed (3 marks)
		 */

		// TODO #2: Write the code here to test for the error condition indicated,
		// and throw a new BadAccountInputException with the message provided.
		// Only if there is no error in the name should this function return true.

		/*
		 * try {
		 * 
		 * } catch (BadAccountInputException e) {
		 * 
		 * }
		 */

	}

	private static boolean isCheckDigitCorrect(String accountNumber) {
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
		// TODO #3: Write the code here to test the account number, according to
		// the algorithm indicated. If the check digit is correct return true,
		// otherwise false. Use the result to throw a new BadAccountInputException
		// in the setAccountNumber() method, with the message "Bad account number;
		// check digit failed." if the result of this method returns false
	}

}
