/*
 *   Driver program to test the BankAccount class
 *   Notes: Cap-L is used to designate a type-long literal
 */

public class TestBankAccount {

	public static void main(String[] args) {

		long nextAcctNo = 10010_100001L;

		BankAccount janeAcct = new BankAccount(nextAcctNo, "Jane Smith Jr.", "123 Main St.",
				555_13_9876, 500.00);
		nextAcctNo++;

		BankAccount momAcct = new BankAccount(nextAcctNo, "Jane Smith Sr.", "123 Main St.",
				555_79_1234, 10_000.00);
		nextAcctNo++;

		BankAccount savingsAcct = new BankAccount(momAcct);
		savingsAcct.setAccount_no(nextAcctNo);
		nextAcctNo++;
		savingsAcct.setBalance(1000.00);

		System.out.println(janeAcct.toString());
		System.out.printf("Mom's account, %d, has balance: $%.2f\n", momAcct.getAccount_no(),
				momAcct.getBalance());
		System.out.println("Mom's Savings account: " + savingsAcct.toString());

		momAcct.deposit(300.00);

		if (!momAcct.transfer(janeAcct, 200.00)) {
			System.out.println("Transfer rejected!");
		}

		double amount = 1500.;
		if (!janeAcct.withdraw(amount)) {
			System.out.printf("Withdrawal $%.2f rejected!\n", amount);
		}

		System.out.printf("Mom's account has balance: $%.2f\n", momAcct.getBalance());
		System.out.printf("Jane's account has balance: $%.2f\n", janeAcct.getBalance());

		if (momAcct.equals(savingsAcct))
			System.out.println("The two accounts are the same!");
		else
			System.out.println("The two accounts are different.");

	}
}