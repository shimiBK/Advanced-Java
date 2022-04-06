import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rational x , y , z;

        System.out.println("Hello, You are about to enter two rational numbers , The numerators are integers . the denominators cant be zero or less than zero Enjoy");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter numerator for the first number");
        int firstNum = myObj.nextInt();
        System.out.println("Enter denominator for first number");
        int firstDen = myObj.nextInt();
        x = new Rational(firstNum,firstDen);
        System.out.println("Enter numerator for second number");
        int secondNum = myObj.nextInt();
        System.out.println("Enter denominator for second number");
        int secondDen = myObj.nextInt();
        y = new Rational(secondNum,secondDen);

        System.out.println("Your first number is: " + x + "\n" + "Your Second number is: " + y);
        System.out.println("Enter denominator for second number");
        z = x.plus(y);
        z = z.reduce(z);
        System.out.println("Result of Addition is " + z.toString());
        z = x.minus(y);
        z = z.reduce(z);
        System.out.println("Result of Subtraction is " + z.toString());
        z = x.multiply(y);
        z = z.reduce(z);
        System.out.println("Result of Multiplication is " + z.toString());
        z = x.divides(y);
        z = z.reduce(z);
        System.out.println("Result of Division is " + z.toString());
        System.out.println("Is X > Y");
        System.out.println(x.greaterThan(y));
        System.out.println("Is X == Y ?");
        System.out.println(x.equals(y));

    }

}

