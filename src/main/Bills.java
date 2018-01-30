package main;

public class Bills {

	private int[] register = new int[7];
	private int total = 0;

	public Bills() {
		for (int i = 0; i < register.length; i++) {
			register[i] = 10;
		}
		findTotal();
	}

	public void restock() {
		for (int i = 0; i < register.length; i++) {
			register[i] = 10;
		}
	}

	public void denominations() {
		if (register[0] != 0) {
			System.out.println("$1000 - " + register[0]);
		}
		if (register[1] != 0) {
			System.out.println("$100 - " + register[1]);
		}
		if (register[2] != 0) {
			System.out.println("$50 - " + register[2]);
		}
		if (register[3] != 0) {
			System.out.println("$20 - " + register[3]);
		}
		if (register[4] != 0) {
			System.out.println("$10 - " + register[4]);
		}
		if (register[5] != 0) {
			System.out.println("$5 - " + register[5]);
		}
		if (register[6] != 0) {
			System.out.println("$1 - " + register[6]);
		}
	}

	public void withdraw(int amount) {
		int orginal = amount;
		int[] hold = new int[7];
		for(int i = 0; i < register.length; i++) {
			hold[i] = register[i];
		}
		findTotal();
		for (int i = 0; i < register.length; i++) {
			if (amount / convert(i) != 0 && !(amount <= 0)) {
				int temp = amount / convert(i);
				if (register[i] >= temp) {
					amount = amount - (temp * convert(i));
					register[i] = register[i] - temp;
				} else {
					amount = amount - (register[i] * convert(i));
					register[i] = 0;
				}

			}
		}
		if (amount == 0) {
			System.out.println("Success: Dispense $" + orginal);
		} else {
			System.out.println("Failure: insufficient funds");
			for(int i = 0; i <hold.length; i++) {
				register[i] = hold[i]; 
			}
		}

	}

	public void findTotal() {
		int sum = 0;
		for (int i = 0; i < register.length; i++) {
			sum += (register[i] * convert(i));
		}
		total = sum;
	}

	public int getTotal() {
		return total;
	}

	public int getBill(int i) {
		return register[i];
	}

	public int convert(int i) {
		if (i == 0) {
			return 1000;
		} else if (i == 1) {
			return 100;
		} else if (i == 2) {
			return 50;
		} else if (i == 3) {
			return 20;
		} else if (i == 4) {
			return 10;
		} else if (i == 5) {
			return 5;
		} else if(i == 6) {
			return 1;
		}
		return 0;
	}

	public int reverseConvert(int i) {
		if (i == 1000) {
			return 0;
		} else if (i == 100) {
			return 1;
		} else if (i == 50) {
			return 2;
		} else if (i == 20) {
			return 3;
		} else if (i == 10) {
			return 4;
		} else if (i == 5) {
			return 5;
		} else if(i == 1) {
			return 6;
		}
		return 0;
	}

}
