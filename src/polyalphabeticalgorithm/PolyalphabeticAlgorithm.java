package polyalphabeticalgorithm;

import java.util.Scanner;

public class PolyalphabeticAlgorithm {

    static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String vigenereEncryption(String plainText, String key) {

        String cipher = "";
        int plainChar;
        int keyChar;
        int[] newChar = new int[plainText.length()];
        String newKey = "";
        int count = 0;

        for (int i = 0; i < plainText.length(); i++) {
            if (count == key.length()) {
                count = 0;
            }

            newKey = newKey + key.charAt(count);
            count++;

        }

        for (int i = 0; i < plainText.length(); i++) {

            plainChar = letters.indexOf(plainText.charAt(i));
            keyChar = letters.indexOf(newKey.charAt(i));
            newChar[i] = (plainChar + keyChar) % 26;
        }

        for (int i = 0; i < plainText.length(); i++) {
            cipher += letters.charAt(newChar[i]);
        }

        return cipher;
    }

    public static String vernamEncryption(String plainText, String key) {

        int res;
        String t = "";
        String cipher = "";
        int count = 0;
        String myKey = "";

        for (int i = 0; i < plainText.length(); i++) {

            if (count == key.length()) {
                count = 0;
            }

            myKey = myKey + key.charAt(count);
            count++;
        }

        for (int i = 0; i < plainText.length(); i++) {
            int keyChar = (int) myKey.charAt(i);
            int plainChar = (int) plainText.charAt(i);
            res = (int) (keyChar ^ plainChar);
            
            t = String.format("%02X", res);
            cipher += t;
        }

        return cipher;
    }

    public static String isOneTimePad(String plainText, String key) {

        String result = null;
        if (plainText.length() == key.length()) {
            result = "YES";
        } else {
            result = "NO";
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String key = scan.next();
        String plainText = scan.next();
        System.out.println("Vigenere: " + vigenereEncryption(plainText, key));
        System.out.println("Vernam: " + vernamEncryption(plainText, key));
        System.out.println("One-Time Pad: " + isOneTimePad(plainText, key));

    }

}
