package ATM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {
	String name;
	String DOB;
	long accountNo;
	byte age;
	long AadhaarNumber;
	double balance;
	long phoneNo;
	long CardNo;
	
	ArrayList<String> history = new ArrayList<>();

	BankAccount(String name, String DOB, long accountNo, byte age, long AadhaarNumber, double balance, long phoneNo,
			long CardNo, ArrayList<String> history) {
		this.name = name;
		this.DOB = DOB;
		this.accountNo = accountNo;
		this.age = age;
		this.AadhaarNumber = AadhaarNumber;
		this.balance = balance;
		this.phoneNo = phoneNo;
		this.CardNo = CardNo;
		this.history = history;
	}

	BankAccount() {
		// TODO Auto-generated constructor stub
	}
//-----------------------------------------------------------------------------	

	public static HashMap<Card, BankAccount> users = new HashMap<Card, BankAccount>();
//------------------------------------------------------------------------------
	public static BankAccount getUserDetails(long cardNo, int pin) {
		for (Map.Entry<Card, BankAccount> entry : users.entrySet()) {
			BankAccount u = entry.getValue();
			Card c = entry.getKey();
			if (u.CardNo == cardNo && c.getPin() == pin) {
				return u;
			}
		}
		return null;
		}
//-----------------------------------------------------------------------------

	public static boolean checkCard(long cardNo) {
		for (Map.Entry<Card, BankAccount> entry : users.entrySet()) {
			BankAccount u = entry.getValue();
			Card c = entry.getKey();
			if (u.CardNo == cardNo) {
				if (c.validityCard.isAfter(LocalDate.now()))
					return true;
				}
		}
		return false;
	}
	
//---------------------------------------------------------------------------
	public static boolean getUserDetails(long cusAcc) {
		for (Map.Entry<Card, BankAccount> entry : users.entrySet()) {
				BankAccount u = entry.getValue();
			if (u.accountNo == cusAcc)
				return true;
			}
		return false;
	}
//-------------------------------------------------------------------------
	public static BankAccount getTransactionUserDetails(long cusAcc) {
		for (Map.Entry<Card, BankAccount> entry : users.entrySet()) {

			BankAccount u = entry.getValue();
			if (u.accountNo == cusAcc)
				return u;
		}
		return null;
	}
//---------------------------------------------------------------------------
	public static Card getCardDetails(long cardNo) {
		for (Map.Entry<Card, BankAccount> entry : users.entrySet()) {
			Card u = entry.getKey();
			if (u.cardNo== cardNo) 
				return u;
		}
		return null;
	}
//-----------------------------------------------------------------------------
}
