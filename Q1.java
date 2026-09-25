import java.util.Scanner;

public class CharacterClassification {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a single character: ");
        char ch = input.next().charAt(0);

        if (Character.isDigit(ch)) {
            System.out.println("The character is a digit.");
        } 
        else if (Character.isLetter(ch)) {

            System.out.println("The character is a letter.");

            if (Character.isUpperCase(ch)) {
                System.out.println("The letter is uppercase.");
            } 
            else if (Character.isLowerCase(ch)) {
                System.out.println("The letter is lowercase.");
            }
        } 
        else {
            System.out.println("The character is neither a digit nor a letter.");
        }

        input.close();
    }
}