import java.util.Scanner;

 class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a password to check its strength: ");
        String password = input.nextLine();

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");

        System.out.println("Password Strength Analysis:");
        System.out.println("Length: " + length);
        System.out.println("Uppercase Letter: " + hasUppercase);
        System.out.println("Lowercase Letter: " + hasLowercase);
        System.out.println("Number: " + hasDigit);
        System.out.println("Special Character: " + hasSpecialChar);

        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            System.out.println("Password is strong!");
        } else {
            System.out.println("Password is weak. Please consider adding more characters, including uppercase, lowercase, numbers, and special characters.");
        }
    }
}

