package components;
import java.util.Scanner;

public class Shifter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a binary number Please");
		String binaryText = input.nextLine();
		long binaryNumber = Long.parseLong(binaryText, 2);
		int menuChoice;
		do {
			Long binaryDisplay = Long.parseLong(Long
					.toBinaryString(binaryNumber));
			System.out.print("The Binary Number : ");
		    System.out.printf("%08d = %d%n",binaryDisplay, binaryNumber);
			System.out.println("1. Shift bits to the right");
			System.out.println("2. Shift bits to the left");
			System.out.println("3. Exit ");
			System.out.println("Enter choice:");
			menuChoice = input.nextInt();

			if (menuChoice == 1) {
				binaryNumber = binaryNumber >> 1;
				System.out.println("Shifted to the right" +" = "+ binaryNumber );
			} else if (menuChoice == 2) {
				binaryNumber = binaryNumber << 1;
				System.out.println("Shifted to the left" +" = " +binaryNumber );

			} else if(menuChoice >3){
				System.out.println("Please Choose A valid choice");
			}
		} while (menuChoice != 3);

	}

}
