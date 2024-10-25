package ATM;

import java.util.Scanner;

public class Util {

	static Scanner sc = new Scanner(System.in);
//--------------------------------------------------------------------------------
	public static long getLongValue() {
		long cardNos = 0;
		while (true) {
			if (sc.hasNextLong()) {
				cardNos = sc.nextLong();
				break;
			} else {
				System.out.println("Enter Numbers only");
				sc.nextLine();
				}
			}
		return cardNos;
		}
//-----------------------------------------------------------------------------
	public static int getIntegerValue() {
		int pins = 0;
		while (true) {
			if (sc.hasNextInt()) {
				pins = sc.nextInt();
				break;
			} else {
				System.out.println("Enter Numbers only");
				sc.nextLine();
			}
		}
		return pins;
	}
//------------------------------------------------------------------------------
	public static double getDoubleValue() {
		double money = 0.0;
		while (true) {
			if (sc.hasNextDouble()) {
				money = sc.nextDouble();
				break;
			} else {
				System.out.println("Enter Numbers only");
				sc.nextLine();
			}
		}
		return money;
	}
//-------------------------------------------------------------------------------

} 
