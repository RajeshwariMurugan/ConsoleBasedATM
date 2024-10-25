package ATM;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ATM {
	static Admin admin=new Admin();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//-----------------------------------------------------------------------------
			BankAccount bank=new BankAccount();
		
		BankAccount user1=new BankAccount("Raji","04/07/2001",98765l,(byte)22,728867157922l,1000.00,994082344l,12345678l,new ArrayList<>());
		Card cardNo1=new Card(12345678l,1234,LocalDate.of(2024, 02, 28));
		bank.users.put(cardNo1,user1);
		
		BankAccount user2=new BankAccount("Banu","18/12/2001",87659l,(byte)22,288671579227l,2000.00,8901235678l,56789123l,new ArrayList<>());
		Card cardNo2=new Card(56789123l,5678,LocalDate.of(2024, 02, 28));
		bank.users.put(cardNo2, user2);
		
	    BankAccount user3=new BankAccount("Gokila","03/04/2001",76598l,(byte)22,886715792272l,2500.00,9952873994l,90123456l,new ArrayList<>());
		Card cardNo3=new Card(90123456l,9012,LocalDate.of(2024,02, 28));
		bank.users.put(cardNo3, user3);
		
        Util input=new Util();
//-------------------------------------------------------------------------------
boolean flag = true;
while (flag){
	  System.out.println("******** Welcome To Surandai Branch ATM *******\n ******** INDIAN OVERSEAS BANK **********");
	  System.out.println("Enter 1--> Insert a Card");
      int ch=input.getIntegerValue();
      
      // After insert a card----------------------->
      
      
      
	   switch(ch){
	   		case 1:
		         System.out.println("Enter your 16 digit Card Number");
		         long CardNos=input.getLongValue();
		         System.out.println(" Hi! Please do not Remove your Chip Card. \n     Leave your Card Inserted during \n        the Entire Transaction");
		         System.out.println("Please Enter Your PIN");
		         int Pins=input.getIntegerValue();
			
		  		  BankAccount card=new BankAccount();
					
		  					if(String.valueOf(CardNos).length()==8 && String.valueOf(Pins).length()==4 &&card.checkCard(CardNos))
		  					{
		  						card=card.getUserDetails(CardNos, Pins);
		  	//if i get a user details-->
		  						
		  						if(card!=null)
		  						{
		  		                 // System.out.println("Welcome " +card.name+" ! ");
		  							 System.out.println("HELLO CUSTOMER ! ");
System.out.println("Enter Your Choice \n Press 1--> Cash Deposit  \n Press 2--> Cash Withdrawal \n Press 3--> Balance Inquiry \n "+ "Press 4--> PIN Change \n Press 5--> FAST Cash \n Press 6--> MINI STATEMENT \n Press 7--> Exit ");
								  int opt=input.getIntegerValue();
	         // Choose the options
								  switch (opt)
									{
										case 1:
											deposited(card,3);
											System.out.println("Collect your Card");
											break;
										case 2:
											Withdrawl(card,3);
											System.out.println("Collect your Card");
											break;
										case 3:
											System.out.println("ViewBalance");
											System.out.println("If You want Receipt ? Press 1 else Press OtherNumber");
											int recipt=input.getIntegerValue();
											if(recipt==1)
												getReceipt(card);
											else
												System.out.println("Your Balance is " +card.balance);
											break;
										case 4:
											int otp = ((int) Math.random() * 9999 >= 1000) ? (int) Math.random() * 9999
													: (int) (Math.random() * 9999) + 1000;
											System.out.println("OTP: " + otp);
											System.out.println(card.phoneNo +"	got a OTP");
											System.out.println("Enter OTP");
											int OTP = input.getIntegerValue();
											Card cards=card.getCardDetails(CardNos);
											if (otp == OTP) 
											{
												System.out.println("Enter Your 4 digit New Pin");
												int newPin = input.getIntegerValue();
												
												if(String.valueOf(newPin).length()==4)
												{
												cards.setPin(newPin);
												System.out.println(cards.getPin());
												System.out.println("Your Pin is Successfully Changed");
												break;
												}
												else
												{
													System.out.println(" Sorry Invalid pin.....");
													
												}
											}
											break;
										case 5:
											System.out.println("Welcome to Fast Fund Amount Page");
											FastFund(card);
											break;
										case 6:
											System.out.println("Mini Statement");
											MINISTATEMENT(card);
											break;
										case 7:
											System.out.println(".....Thanks For Your Visit....");
											flag = false;
									    break;
										default:
											System.out.println("Enter Correct Value");
										
									}//Switch finished
		  						} // card is not null if case finished
		  						else
		  							System.out.println("Enter Correct Card Number Or Pin");
	
		  						}//card validity check
		  					else
		  						System.out.println("Invalid Card");
		  					}//switch finished
	   }//while finished

	}//Main method finised

	private static void Withdrawl(BankAccount card, int num) {
		// TODO Auto-generated method stub
	//	System.out.println("Withdraw Operation Processing....");
		System.out.println("Please Enter Amount");
		System.out.println("(Cash Available: "+admin.availableMoney()+" )");
		double Balance1 = Util.getDoubleValue();
		
		if(num!=0)
		{
			if (Balance1 >= 100 && card.balance-Balance1>=100) {
				if(Balance1%100==0 && admin.Denomination(Balance1)&&Balance1%100==0) {
					card.balance=card.balance-Balance1;
					System.out.println("SuccessFully Withdraw!!... Get Your Cash!!");
			getReceipt(card);
			card.history.add(0,""+java.time.LocalDate.now()+"	"+new SimpleDateFormat("HH:mm:ss:a").format(new Date())+"   "+"Withdrawl"+"                   "+Balance1);
			}
				else
					System.out.println("ATM has no Money");
			}
			else
			{
				System.out.println("Insufficient Money");
				Withdrawl(card,num--);
			}
		}
	}

	private static void deposited(BankAccount card,int num) {
		// TODO Auto-generated method stub
		 System.out.println("Please Enter Amount");
		 System.out.println("(Deposit Notes)");
		double Balance =Util.getDoubleValue();
		
		if(num!=0) {
			
		if (Balance >= 100 && Balance<=35000 && Balance%100==0){
			card.balance=card.balance+Balance;
			System.out.println("Please Wait Processing notes....");
			System.out.println("Your deposited amount is "+Balance);
			card.history.add(0,""+java.time.LocalDate.now()+"	"+new SimpleDateFormat("HH:mm:ss:a").format(new Date())+"   "+"Deposited"+"                   "+Balance);
			System.out.println("Your Cash is being deposited!!");
			getReceipt(card);
		}
		else 
		{
			System.out.println("Please Deposited amount is must greater than 100 and lesser than 35000");
			num--;
			deposited(card,num);
		}
	}


		
	}
	
	
	private static void getReceipt(BankAccount card) {
		// TODO Auto-generated method stub
		System.out.println("Get Recepit");

		System.out.println("........................................");
		System.out.println("       ATM TRANSACTION RECORD      ");
		System.out.println("........................................");
		System.out.println("DATE:	                 " + java.time.LocalDate.now());
		System.out.println(
				"TIME:	          	   " + new SimpleDateFormat("HH:mm:ss:a").format(new Date()));
		System.out.println("LOCATION:                    SURANDAI");
		System.out.println("ATM Number :                    627859");
		System.out.println(".......................................");

		int a = (int) (Math.random() * 9999);
		System.out.println("RECEIPT NO: 	             " + (a < 1000 ? a + 1000 : a));
		System.out.println("Account NO:                  " + card.accountNo);
		System.out.println("CUSTOMER NAME:            " + card.name);
		System.out.println("YOUR BALANCE :          " + card.balance);
		System.out.println();
		System.out.println("          THANKING YOU      ");
		System.out.println("------------------------------------------------------------");
		}// getReceipt Method
	
	
	
	public static void FastFund(BankAccount card)
	{
		System.out.println("Enter 1-->100 \n Enter 2-->200 \n Enter 3-->500 \n Enter 4-->1000");
		System.out.println("ENter 5-->1500 \n Enter 6--> 2000 \n Enter 7-->5000 \n Enter 8-->10000");
	int arr[]= {0,100,200,500,1000,1500,2000,5000,10000};
		int money=Util.getIntegerValue();
		
		try {
		if (card.balance-arr[money]>=100) 
		{
			card.balance=card.balance-arr[money];
			System.out.println("SuccessFully Withdraw!!... Get Your Cash!!");
			getReceipt(card);
card.history.add(0,""+java.time.LocalDate.now()+"	"+new SimpleDateFormat("HH:mm:ss:a").format(new Date())+"   "+"Withdraw"+"                  "+money);

			System.out.println("Please Eject Your Card");
		}
		else
		{
			System.out.println("Insufficient Money");
			System.out.println("Your Balance is "+card.balance);
			FastFund(card);
		}
		}
		catch(Exception e)
		{
			System.out.println("Please enter correct value");


		}
		
		
	}
	
	
		public static void MINISTATEMENT(BankAccount card)
		{
			System.out.println("Get Recepit");

			System.out.println("........................................");
			System.out.println("       ATM  MINI STATEMENT      ");
			System.out.println("........................................");
			System.out.println("DATE:	                 " + java.time.LocalDate.now());
			System.out.println(
					"TIME:	          	   " + new SimpleDateFormat("HH:mm:ss:a").format(new Date()));
			System.out.println("LOCATION:                    SURANDAI");
			System.out.println("ATM Number :                    627859");
			System.out.println(".......................................");

			int a = (int) (Math.random() * 9999);
			System.out.println("RECEIPT NO: 	             " + (a < 1000 ? a + 1000 : a));
			System.out.println("Account NO:                  " + card.accountNo);
			System.out.println("CUSTOMER NAME:                " + card.name);
			
			System.out.println();
			
			if(card.history.size()==0)
				System.out.println("------NO Transaction------");
			
			for(int i=0;i<card.history.size();i++)
			{
				if(i<10)
				System.out.println((i+1)+".  "+card.history.get(i));
			}
			
			System.out.println();
			System.out.println("          THANKING YOU      ");
			System.out.println("------------------------------------------------------------");
		
			
			
			


	
		}
	
	
}