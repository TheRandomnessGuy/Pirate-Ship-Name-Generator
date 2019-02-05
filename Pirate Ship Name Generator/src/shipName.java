import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class shipName {
	
	static Random ran = new Random();
	
	static String[] leftSide;
	static File leftFile = new File("leftSide.csv");
	static String[] rightSide;
	static File rightFile = new File("rightSide.csv");
	
	public static void main(String[] args) {
		
		try{
			Scanner inputStream = new Scanner(leftFile);
			String line = inputStream.nextLine();
			inputStream.close();
			leftSide = line.split(", ");

			inputStream = new Scanner(rightFile);
			line = inputStream.nextLine();
			inputStream.close();
			rightSide = line.split(", ");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many names would you like to generate?");
		int count = keyboard.nextInt();
		keyboard.close();
		
		for (int i = 0; i < count; i++) {
			System.out.println(generate());
		}
	}
	
	public static String generate() {
		int leftNum = ran.nextInt(leftSide.length);
		int rightNum = ran.nextInt(rightSide.length);
		
		return (leftSide[leftNum] + " " + rightSide[rightNum]);
	}
}