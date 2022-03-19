/*
 * Write a command-line program in the language of your choice that will take
 * operations on fractions as an input and produce a fractional result.
 * Legal operators shall be *, /, +, - (multiply, divide, add, subtract)
 * Operands and operators shall be separated by one or more spaces.
 * Mixed numbers will be represented by whole_numerator/denominator. e.g."3_1/4"
 * Improper fractions and whole numbers are also allowed as operands
 * Example run:
 * ? 1/2 * 3_3/4
 * = 1_7/8
 * ?2_3/8 + 9/8
 * = 3_1/2
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String fractionOne, operand, fractionTwo;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the fractions statement with following operands (+,-,/,*) as shown below:");
        System.out.println("Example: \"? 1/2 * 3_3/4\"");

        // input statement
        String input = sc.nextLine();
        String[] statement = input.split(" ");

        // checking inputs
        if (!validInputStatement(statement)) {
            System.out.println("Invalid Inputs!");
            System.exit(0);
        }

        // input fractions and operand
        fractionOne = statement[1];
        operand = statement[2];
        fractionTwo = statement[3];

        // converting string input numbers to double numbers
        double validFractionOne = convertInputFromStringToDouble(fractionOne);
        double validFractionTwo = convertInputFromStringToDouble(fractionTwo);

        // perform input operation on input fraction numbers
        double operationResult = performOperation(validFractionOne, validFractionTwo, operand);

        // convert double decimal value to fraction
        String answer = convertDecimalToFraction(operationResult);

        // print output
        System.out.println("= " + answer);
        sc.close();
    }

    // function to check validity of input values
    public static boolean validInputStatement(String[] statement) {
        if (statement[0].equals("?")) {
            return true;
        }
        return false;
    }

    // convert string fraction value to double decimal values
    public static double convertInputFromStringToDouble(String input) {
        if (input.contains("_")) {
            double result;
            String[] str = input.split("_");
            double valueOne = Double.parseDouble(str[0]);
            double valueTwo = convertFractionToDecimal(str[1]);
            result = valueOne + valueTwo;
            return result;
        }
        return convertFractionToDecimal(input);
    }

    // convert fraction value to double decimal
    public static double convertFractionToDecimal(String x) {
        String[] str = x.split("/");
        double numerator = Double.parseDouble(str[0]);
        double denominator = Double.parseDouble(str[1]);
        double result = numerator / denominator;
        return result;
    }

    // function to perform input operand on fraction values
    public static double performOperation(double validInputOne, double validInputTwo, String operand) {
        double result = 0;
        if (operand.equals("+"))
            result = validInputOne + validInputTwo;
        else if (operand.equals("-"))
            result = validInputOne - validInputTwo;
        else if (operand.equals("*"))
            result = validInputOne * validInputTwo;
        else if (operand.equals("/"))
            result = validInputOne / validInputTwo;
        else
            System.out.println("Operand is not supported!");
        return result;
    }

    // convert double decimal value into fraction value
    public static String convertDecimalToFraction(double input) {
        if (input < 0) {
            return "-" + convertDecimalToFraction(-input);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = input;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(input - h1 / k1) > input * tolerance);
        if (h1 > k1 && (int) k1 != 1) {
            String result = toMixedFraction((int) h1, (int) k1);
            return result;
        }
        return (int) h1 + "/" + (int) k1;
    }

    // convert improper fraction into mixed fraction
    public static String toMixedFraction(int numerator, int denominator) {
        String mixedFraction;
        int wholeNumber;
        wholeNumber = Math.floorDiv(numerator, denominator);
        mixedFraction = wholeNumber + "_" + (numerator - wholeNumber * denominator) + "/" + denominator;
        return mixedFraction;
    }
}