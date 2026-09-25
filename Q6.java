import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter gross pay (X): ");
            double grossPay = sc.nextDouble();
            
            System.out.print("Enter tax rate (T): ");
            double taxRate = sc.nextDouble();
            
            double tax = grossPay * taxRate / 100;
            double takeHomePay = grossPay - tax;
            
            System.out.println("Your gross pay is " + grossPay +
                    " and take home pay is " + takeHomePay);
            
            if (takeHomePay >= 2800) {
                System.out.println("You are doing reasonably well!!!");
            }
        }
    }
}