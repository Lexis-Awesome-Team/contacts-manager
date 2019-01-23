package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public boolean yesNo() {
        String input = getString();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public boolean yesNo(String prompt) {
        System.out.print(prompt + " ");
        return yesNo();
    }

    public int getInt() {
        return scanner.nextInt();
    }

    public int getInt(String prompt) {
        System.out.print(prompt + " ");
        return getInt();
    }

    public int getInt(int min, int max) {
        int userInt = getInt();
        if(userInt >= min && userInt <= max) {
            return userInt;
        } else {
            System.out.println("The number must be between " + min + " and " + max);
            return getInt(min, max);
        }
    }

    public int getInt(String prompt, int min, int max) {
        System.out.print(prompt + " ");
        return getInt(min, max);
    }

    public String getString() {
        return scanner.next();
    }

    public String getString(String prompt) {
        System.out.print(prompt + " ");
        return getString();
    }

    public double getDouble() {
        return scanner.nextDouble();
    }

    public double getDouble(String prompt) {
        System.out.print(prompt + " ");
        return getDouble();
    }

    public double getDouble(double min, double max) {
        double userDouble = getDouble();
        if(userDouble >= min && userDouble <= max) {
            return userDouble;
        } else {
            System.out.print("The number must be between " + min + " and " + max);
            return getDouble(min, max);
        }
    }

    public double getDouble(double min, double max, String prompt) {
        System.out.print(prompt + " ");
        return getDouble(min, max);
    }
}
