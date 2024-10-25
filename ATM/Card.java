package ATM;

import java.time.LocalDate;

public class Card {

	long cardNo;
	private int pin;
	LocalDate validityCard;

	Card(long cardNo, int pin, LocalDate validityCard) {
		this.cardNo = cardNo;
		this.pin = pin;
		this.validityCard = validityCard;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getPin() {
		// TODO Auto-generated method stub
		return pin;
	}

}
