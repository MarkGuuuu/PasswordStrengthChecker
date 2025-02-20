import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * This class will check the content of password to indicate how strong it is.
 * Once user inputs a password, the program will print the score of it, feedback and
 * a strength bar to visualize the strength.
 * @author Mark Gu
 * @version 1.0
 * @date 2025-02-20
 */
public class CheckingPasswordSafety {
    private static final int MIN_LENGTH = 8;
    private static final int STRONG_LENGTH = 12;

    /**
     * This method checks for the strength of the password. It takes a string as
     * an input to check its strength by checking a few conditions.
     * e.g. Does it contain any number? Does it contain lowercase or uppercase letter?
     * @param inputPassword--a string object whose content is the password.
     * @return Password--a password object which has its information of strength and feedback.
     */
    public static Password checkStrength(String inputPassword) {
        if (inputPassword == null || inputPassword.isEmpty()) {
            return new Password("", 0, "Password cannot be empty");
        }

        int score = 0;
        StringBuilder feedback = new StringBuilder();

        //Check the password's length.
        if (inputPassword.length() < MIN_LENGTH) {
            feedback.append("Password is too short (minimum " + MIN_LENGTH + " characters)\n");
        } else {
            score += 2;
            if (inputPassword.length() >= STRONG_LENGTH) {
                score += 2;
            }
        }

        // Check if password has number
        if (Pattern.compile("[0-9]").matcher(inputPassword).find()) {
            score += 2;
        } else {
            feedback.append("Add numbers for stronger password\n");
        }

        // Check if password has any uppercase letter
        if (Pattern.compile("[A-Z]").matcher(inputPassword).find()) {
            score += 2;
        } else {
            feedback.append("Add uppercase letters for stronger password\n");
        }

        // Check if password has any lowercase letter
        if (Pattern.compile("[a-z]").matcher(inputPassword).find()) {
            score += 2;
        } else {
            feedback.append("Add lowercase letters for stronger password\n");
        }

        // Check if password has any specicial character to increase the strength
        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(inputPassword).find()) {
            score += 2;
        } else {
            feedback.append("Add special characters for stronger password\n");
        }

        // Check to see if the password has simple pattern. e.g. 123...
        if (Pattern.compile("1234567890|abc|password", Pattern.CASE_INSENSITIVE)
                .matcher(inputPassword).find()) {
            score -= 3;
            feedback.append("Avoid common password patterns\n");
        }

        // Check for repeated characters in a sequence of 3 or more times.
        if (Pattern.compile("(.)\\1{2,}").matcher(inputPassword).find()) {
            score -= 2;
            feedback.append("Avoid repeated characters\n");
        }

        //Perfect password.
        if (feedback.length() == 0) {
            feedback.append("Password meets all criteria");
        }

        //Level current password.
        String strengthLevel;
        if (score >= 8) {
            strengthLevel = "Strong";
        } else if (score >= 6) {
            strengthLevel = "Moderate";
        } else if (score >= 4) {
            strengthLevel = "Weak";
        } else {
            strengthLevel = "Very Weak";
        }

        return new Password(inputPassword, score, strengthLevel + ": " + feedback.toString().trim());
    }

    /**
     * This main method will keep printing password information such as strength and feedback
     * unless user stop inputting any new password.
     * @param args--user input, it should be a string.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Password Safety Checker ");
            System.out.println("Please enter your password to check its safety (or 'quit' to exit):");

            String inputPassword = scanner.nextLine().trim();

            if (inputPassword.equalsIgnoreCase("quit")) {
                System.out.println("You have quited the Password Safety Checker. Please run again if you are going to check more passwords.");
                break;
            }

            Password result = checkStrength(inputPassword);

            System.out.println("\nResults:");
            System.out.println("Password: " + result.getPassword());
            System.out.println("Safety Score: " + result.getSafetyScore() + "/10");
            System.out.println("Feedback: " + result.getFeedback());

            //show a bar to indicate the strength of the password.
            System.out.print("Strength: ");
            int score = result.getSafetyScore();
            String GREEN = "\u001B[32m";
            String RED = "\u001B[31m";
            String RESET = "\u001B[0m";
            String filled = GREEN + "■" + RESET;
            String empty = RED + "□" + RESET;
            System.out.println(filled.repeat(score) + empty.repeat(10 - score));
        }

        scanner.close();
    }
}