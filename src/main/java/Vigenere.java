import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        StringBuilder output = new StringBuilder();
        int curKey;
        int i = 0;
        for (char c : message.toCharArray()) {
            curKey = key.charAt(i % key.length()) - 65;
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c - 65 + curKey) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c - 97 + curKey) % 26) + 97 : c));
            i += ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')) ? 1 : 0;
        }
        return output.toString();
    }

    public static String decryptVigenere(String message, String key) {
        StringBuilder output = new StringBuilder();
        int curKey;
        int i = 0;
        for (char c : message.toCharArray()) {
            curKey = key.charAt(i % key.length()) - 65;
            output.append((char) ((c <= 'Z' && c >= 'A') ? ((c - 39 - (curKey % 26)) % 26) + 65 : (c <= 'z' && c >= 'a') ? ((c - 71 - (curKey % 26)) % 26) + 97 : c));
            i += ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')) ? 1 : 0;
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
        String key = scan.nextLine().trim();
        System.out.println("Here is your " + command + "ed message: ");
        System.out.println((command.equals("encrypt")) ? encryptVigenere(message, key) : (command.equals("decrypt")) ? decryptVigenere(message, key) : "Error");
        scan.close();
    }
}
