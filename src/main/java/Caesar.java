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
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c - 42) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c - 74) % 26) + 97 : c));
        }
        return output.toString();
    }

    public static String encryptCaesarKey(String message, int key) {
        StringBuilder output = new StringBuilder();
        for (char c : message.toCharArray()) {
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c - 65 + key) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c - 97 + key) % 26) + 97 : c));
        }
        return output.toString();
    }

    public static String decryptCaesarKey(String message, int key) {
        StringBuilder output = new StringBuilder();
        for (char c : message.toCharArray()) {
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c - 39 - (key % 26)) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c - 71 - (key % 26)) % 26) + 97 : c));
        }
        return output.toString();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();
        System.out.println("Please enter your message to be " + command + "ed: ");
        String message = scan.nextLine().trim();
        System.out.println("Please enter the key for your message: ");
        int key = scan.nextInt();
        System.out.println("Here is your " + command + "ed message: ");
        System.out.println((command.equals("encrypt")) ? encryptCaesarKey(message, key) : (command.equals("decrypt")) ? decryptCaesarKey(message, key) : "Error");
        scan.close();
    }
}
