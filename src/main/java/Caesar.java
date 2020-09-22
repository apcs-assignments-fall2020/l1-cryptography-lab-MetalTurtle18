import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        StringBuilder output = new StringBuilder();
        for (char c : message.toCharArray()) {
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c - 62) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c - 94) % 26) + 97 : c));
        }
        return output.toString();
    }

    public static String decryptCaesar(String message) {
        StringBuilder output = new StringBuilder();
        for (char c : message.toCharArray()) {
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c + 10) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c + 4) % 26) + 97 : c));
        }
        return output.toString();
    }

    public static String encryptCaesarKey(String message, int key) {
        return message;
        // REPLACE THIS WITH YOUR CODE
    }

    public static String decryptCaesarKey(String message, int key) {
        return message;
        // REPLACE THIS WITH YOUR CODE
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
