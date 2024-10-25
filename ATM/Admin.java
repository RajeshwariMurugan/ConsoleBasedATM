package ATM;


public class Admin {
		static int R2000=1, R500=1, R100=1, R200=1;
		
		Admin()
		{
			System.out.println();
		}
		Admin(int R2000, int R500, int R100, int R200)
		{
			this.R100=R100;
			this.R200=R200;
			this.R500=R500;
			this.R2000=R2000;
		}

		
		//.......................................... Admin Load Money ...............................................
		
		
		static void ViewDetails()
		{
			System.out.println("2000 Rupees Note --> "+ R2000);
			System.out.println("500 Rupees Note--> "+R500);
			System.out.println("200 Rupees Note --> "+R200);
			System.out.println("100 Rupees Note --> "+R100);
			
		}
		static void MoneyAccess()
		{
			boolean gus=true;
			Util input=new Util();
			while(gus)
			{
			
			System.out.println("Enter add Money 1--> 2000 \n 2--> 500 \n 3--> 200 \n 4--> 100 \n   Exit-->0");
			
			int option=input.getIntegerValue();
			
			switch(option)
			{
			case 1:
				System.out.println("How Many 2000 amount Added");
				 R2000+=input.getIntegerValue();
				 break;
				 
			case 2:
				System.out.println("How Many 500 amount Added");
				 R500+=input.getIntegerValue();
				 break;
				 
			case 3:
				System.out.println("How Many 200 amount Added");
				 R200+=input.getIntegerValue();
				 break;
				 
			case 4:
				System.out.println("How Many 100 amount Added");
				 R100+=input.getIntegerValue();
				 break;
				 
				 
			case 0:
				gus=false;
				break;
				
				default:
					System.out.println("Enter correct Value");
			}
		}
		}	
		

		//  ............................... Denomination Process .............................................
		
		public static boolean Denomination(double amount)
		{
			int amt=(int)amount;
		int r2000=0,r500=0,r200=0,r100=0,r50=0,r20=0,r10=0,r5=0,r2=0,r1=0;
			
			while(amt>=2000 && R2000>0)
			{
				if(R2000>r2000)
				{
				r2000=amt/2000;
				amt=amt%2000;
				R2000=R2000-r2000;
				}
		//	if(R2000<=0)break;
//					System.out.println("ADMIN ALERT!!!!! 2000 rupee almost EMpty");
//				else
					System.out.println("The number of 2000 Rupees Notes : "+r2000);
				
			break;

			}
			
			while(amt>=500 && R500>0)
			{
				if(R500>r500)
				{
				r500=amt/500;
				amt=amt%500;
				R500=R500-r500;
				}
		System.out.println("The number of 500 Rupees Notes : "+r500);
					break;
			}
			
			
			while(amt>=200 && R200>0)
			{
				if(R200>r200)
				{
				r200=amt/200;
				amt=amt%200;
				R200=R200-r200;

				}
			System.out.println("The number of 200 Rupees Notes : "+r200);

				break;
			}
			
			
			while(amt>=100 && R100>0)
			{
				if(R100>r100)
				{
				r100=amt/100;
				amt=amt%100;
				R100=R100-r100;
				}
			System.out.println("The number of 100 Rupees Notes : "+r100);
				break;
			}
			
			
					
			int count=r2000+r500+r200+r100;
			
			if((R2000<=0 || R500<=0 || R200<=0 || R100<=0 )&& amt!=0)
			{
				//System.out.println("ADMIN ALERT!!!!!  Money EMpty");
				return false;
			}
			
			else
			{
			System.out.println("Total Number of Money required "+count);
			return true;
			}

			
			
		}
		public String availableMoney() {
			// TODO Auto-generated method stub
			String temp="";
			
			if(R2000>0)
				temp+= "Rs.2000 ";
			if(R500>0)
				temp+="Rs.500 ";
			if(R200>0)
				temp+="Rs.200 ";
			if(R100>0)
				temp+="Rs.100 ";
			else
				temp+="Sorry !! ATM has no Money";
			return temp;
		}


}
