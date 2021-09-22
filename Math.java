/*This is a program that solves for x in any quadratic equation in standard form
(ax^2 + bx + c = 0) e.g x^2 + 3x - 1 = 0, using the quadratic formula*/
import java.util.*;

public class Math {
    /*this method for square root was retrieved from this website
    https://medium.com/edureka/java-sqrt-method-59354a700571*/
    public static double square(double number) {
        double t, squareroot = number / 2;
        do {
            t = squareroot;
            squareroot = (t + (number / t)) / 2;
        }
        while ((t - squareroot) != 0);
        return squareroot;
    }
    //The remaining lines of code was done by me
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*You can either input the quadratic equation using fractions such as: 1/6x^2 + 4/3x - 2/3 = 0,
         or as whole numbers: x^2 + 6x - 14 = 0*/
        System.out.print("Enter quadratic equation in standard form(ax^2 + bx + c = 0): ");
        /*String variables from a to d stores a string value separated by a space
         in the quadratic equation which is entered from user input*/
        /*the string variable c1 stores the value of c which will be used later in
        printing the the steps in solving the equation using quadratic formula*/
        String a = input.next(), operator = input.next(), b = input.next(), operator2 = input.next(), c = input.next();
        String operator3 = input.next(), d = input.next(), c1 = c;
        /*these two variables' values will later be changed
        to one which indicates that either variable a or b are double type values*/
        int decimal1 = 0, decimal2 = 0;
        System.out.println("Equation: \n"+a + " " + operator + " " + b + " " + operator2 + " " + c + " " + operator3 + " " + d);
        if ((a.length() == 4) && (a.charAt(0) == '-'))//It checks if the size of the string variable is 4 e.g -x^2 and checks if the first character of the value
            a = a.replace("-","-1");//  equal to "-" in order to replace it with -1 which is a negative number
        if (a.length() == 3)//It checks if the size of a is 3 e.g x^2
            a = "1" + a;//then it concatenates a 1 in front of x^2 which will be used for calculations
        if (b.length() == 1)//It checks if the size of b is 1 e.g x
            b = "1" + b;//then it concatenates a 1 in front of x which will be used for calculations
        String a2 = a.substring(0,a.indexOf("x")), b2 = b.substring(0,b.indexOf("x")), b_number = operator + b.substring(0, b.indexOf("x"));
        /*It checks whether the operators 1 and 2 contain a negative string
        in order to print the  coefficients which are negative numbers and to
        concatenate them with the string variables b2 and c1
        which contains the substring of the numbers in variables b and c*/
        if (operator.equals("-") && operator2.equals("-")){
            System.out.print("Coefficients:\na = "+a.substring(0,a.indexOf("x"))+", b = "+operator + b.substring(0,b.indexOf("x")) + ", c = "+operator2+c);
            b2 = b_number;
            c1 = operator2+c;
        }
        /*If variable operator is negative then variable b and b2 will be negative numbers
        and c will remain positive and a could either be positive or negative depend
        on the substring of a*/
        else if (operator.equals("-")){
            System.out.print("Coefficients:\na = "+a.substring(0,a.indexOf("x"))+", b = "+operator + b.substring(0,b.indexOf("x")) + ", c = "+c);
            b2 = b_number;
        }
        /*If variable operator is negative then variable b and b2 will remain positive numbers,
        c and c1 will be negative and a could either be positive or negative depending
        on the substring of a*/
        else if (operator2.equals("-")){
            System.out.print("Coefficients:\na = "+a.substring(0,a.indexOf("x"))+", b = "+b.substring(0,b.indexOf("x")) + ", c = "+operator2 + c);
            c1 = operator2+c;
        }
        /*If neither operator and operator 2 are negative then variables b, b2, c and c1 will remain positive
        but could either be positive or negative depending on the substring of a*/
        else
            System.out.println("Coefficients:\na = "+a.substring(0,a.indexOf("x"))+", b = "+b.substring(0,b.indexOf("x")) + ", c = "+c);
        /*Each for loop below will check whether a fraction is used for any coefficient
        then it will split them into two parts and store them in an array
        then the numbers will be converted into doubles to later on to be divided and stored into each coefficient,
        once the coefficient variables get reassigned, the variables decimal1 or decimal2 for a and b will be assigned a value 1*/
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '/'){
                String[] num = a.substring(0,a.indexOf("x")).split("/");
                double div = Double.parseDouble(num[0])  / Double.parseDouble(num[1]);
                a = Double.toString(div);
                decimal1 = 1;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '/'){
                String[] num = b.substring(0,b.indexOf("x")).split("/");
                double div = Double.parseDouble(num[0])  / Double.parseDouble(num[1]);
                b = Double.toString(div);
                decimal2 = 1;
            }
        }
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == '/'){
                String[] num = c.split("/");
                double div = Double.parseDouble(num[0])  / Double.parseDouble(num[1]);
                c = Double.toString(div);
            }
        }
        double a1, b1;
        /*If either decimal1 or decimal2 is equal to 1, then the coefficient value of a and b
        in double data type format will be assigned in a1 and b1. If not equal to 1 then a1
        and b1 which will contain whole number(integer) string value that will be converted to double values
        which will be used for calculations*/
        if (decimal1 == 1)
            a1 = Double.parseDouble(a);
        else
            a1 = Double.parseDouble(a.substring(0, a.indexOf("x")));
        if (decimal2 == 1)
            b1 = Double.parseDouble(operator.concat(b));
        else
            b1 = Double.parseDouble(operator.concat(b.substring(0, b.indexOf("x"))));
        double ac = 4 * a1 * (Double.parseDouble(operator2.concat(c)));
        double inside_sqrt = (b1 * b1) - ac;
        String x = "x = (" + (-1 * b1) + " ± √(" + (b1 * b1) + " - " + ac + "))/" + (2 * a1);
        /*If the value within the square root is a negative number
        then it will print the steps which shows the solution as an imaginary number*/
        if (inside_sqrt < 0.0){
            System.out.println("\nStep-by-Step Solution:");
            System.out.println("x = (-b ± √(b^2 - 4ac))/2a");
            System.out.println("x = (-("+b2+") ± √(("+b2+")^2 - 4("+a2+")("+c1+")))/2("+a2+")");
            System.out.println(x);
            System.out.println("x = ("+(-1*b1)+" ± √("+inside_sqrt+"))/"+(2*a1));
            System.out.println("x = ("+(-1*b1)+" ± i√("+(-1*inside_sqrt)+"))/"+(2*a1));
            System.out.print("Answer:\nx = ("+(-1*b1)+" + i√("+(-1*inside_sqrt)+"))/"+(2*a1)+" or x = ("+(-1*b1)+" - i√("+(-1*inside_sqrt)+"))/"+(2*a1));
            System.exit(0);
        }
        //If the number inside the square root is positive then the remaining lines of code will be executed`
        System.out.println("\nStep-by-Step Solution:");
        System.out.println("x = (-b ± √(b^2 - 4ac))/2a");
        System.out.println("x = (-("+b2+") ± √(("+b2+")^2 - 4("+a2+")("+c1+")))/2("+a2+")");
        System.out.println(x);
        System.out.println("x = ("+(-1*b1)+" ± √("+inside_sqrt+"))/"+(2*a1));
        System.out.println("x = ("+(-1*b1)+" ± "+square((b1 * b1) - ac)+")/"+(2*a1));
        System.out.println("x = ("+(-1*b1)+" + "+square((b1 * b1) - ac)+")/"+(2*a1)+" or x = ("+(-1*b1)+" - "+square((b1 * b1) - ac)+")/"+(2*a1));
        System.out.println("x = "+((-1*b1)+square((b1 * b1) - ac))+"/"+(2*a1)+" or x = "+((-1*b1)-square((b1 * b1) - ac))+"/"+(2*a1));
        //It calculates the values for the first and second solution for x and stores them in x1 and x2
        double x1 = (-1 * b1 + square((b1 * b1) - ac)) / (2 * a1), x2 = (-1 * b1 - square((b1 * b1) - ac)) / (2 * a1);
        String ans1 = Double.toString(x1), ans2 = Double.toString(x2);
        /*It gets the size of the substring of ans1 and ans2 starting from the index after "."
        which indicates the number of decimal places, that are stored in size1 and size2*/
        int size1 = (ans1.substring(ans1.indexOf(".") + 1)).length(), size2 = (ans2.substring(ans2.indexOf(".") + 1)).length();
        int decimal_place1 = 0, decimal_place2 = 0;
        //It will print x2 as e.g 1.5, 2.3, etc to 1 decimal place and x1 as 1.56, 0.1666666, etc
        if (size1 != 1 && size2 == 1 && (ans2.charAt(ans2.indexOf(".") + 1)) != '0') {
            System.out.println("Answer:");
            System.out.print("x = " + x1 + " or x = " + x2);
            System.exit(0);
        }
        //It will print x1 as e.g 1.5, 2.3, etc to 1 decimal place and x2 as 1.56, 0.1666666, etc
        if (size2 != 1 && size1 == 1 && (ans2.charAt(ans2.indexOf(".") + 1)) != '0') {
            System.out.println("Answer:");
            System.out.print("x = " + x1 + " or x = " + x2);
            System.exit(0);
        }
        //if the number after the "." is equal to 0, then x1 will be converted to an integer
        if (size1 == 1 && (ans1.charAt(ans1.indexOf(".") + 1)) == '0') {
            System.out.println("Answer:");
            System.out.print("x = " + (int) x1);
            decimal_place1 = 1;
        }
        //if the number after the "." is not equal to 0, then x1 will be printed as a double to 1 decimal place
        else if (size1 == 1 && (ans1.charAt(ans1.indexOf(".") + 1)) != '0') {
            System.out.println("Answer:");
            System.out.print("x = " + x1);
            decimal_place1 = 1;
        }
        //if the number after the "." is equal to 0, then x2 will be converted to an integer
        if (size2 == 1 && (ans2.charAt(ans2.indexOf(".") + 1)) == '0') {
            System.out.print(" or x = " + (int) x2);
            decimal_place2 = 1;
        }
        //if the number after the "." is notd   ghbtugwurqpreu[ewif [ej]    ef equal to 0, then x2 will be printed as a double to 1 decimal place
        else if (size2 == 1 && (ans2.charAt(ans2.indexOf(".") + 1)) != '0') {
            System.out.print(" or x = " + x2);
            decimal_place2 = 1;
        }
        //If the number of decimal places in x1 is grater than 1, then the whole double value will be printed
        if (size1 != 1){
            System.out.println("Answer:");
            System.out.print("x = " + x1);
        }
        //If the number of decimal places in x2 is grater than 1, then the whole double value will be printed
        if (size2 != 1)
            System.out.print(" or x = " + x2);
        /*decimal_place1 and decimal_place2 will indicate whether the value of x1 or x2 contain decimal places greater than 2,
        if they are equal to 0 then the values of x1 and x2 will be rounded off to 2 decimal places*/
        if (decimal_place1 == 0)
            System.out.printf("\nRounded off to 2 d.p: x = %.2f", x1);
        if (decimal_place2 == 0)
            System.out.printf(" or x = %.2f", x2);
    }
}
