import java.util.Scanner;

public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        int strength = 0;
        StringBuilder feedback = new StringBuilder();

        if (password.length() >= 8) {
            strength++;
        } else {
            feedback.append("Password should be at least 8 characters long.\n");
        }

        if (password.matches(".*[A-Z]*.")) {
            strength++;
        } else {
            feedback.append("Add at least one uppercase letter.\n");
        }

        if (password.matches(".*[a-z]*.")) {
            strength++;
        } else {
            feedback.append("Add at least one lowercase letter.\n");
        }

        if (password.matches(".*[0-9]*.")) {
            strength++;
        } else {
            feedback.append("Add at least one number.\n");
        }

        if (password.matches(".*[!@#$%^&(),.?\":{}|<>]*.")) {
            strength++;
        } else {
            feedback.append("Add at least one special character.\n");
        }

        if (strength == 5) {
            return "Strong password ";
        } else if (strength >= 3) {
            return "Moderate password ⚠\nSuggestions:\n" + feedback.toString();
        } else {
            return "Weak password \nSuggestions:\n" + feedback.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String userInput = scanner.nextLine();

        String result = checkPasswordStrength(userInput);
        System.out.println(result);
    }
}
