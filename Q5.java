import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter radius: ");
            double radius = sc.nextDouble();
            
            double area = Math.PI * radius * radius;
            
            System.out.println("Area = " + area);
        }
    }
}