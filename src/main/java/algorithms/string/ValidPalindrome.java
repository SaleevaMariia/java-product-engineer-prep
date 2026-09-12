package algorithms.string;

import java.util.Locale;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    //O(n) + O(n)
    public static boolean isPalindrome(String s) {
        StringBuilder cleanString = new StringBuilder();
        s = s.toLowerCase(Locale.ROOT);
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isLetterOrDigit(temp)) {
                cleanString.append(temp);
            }
        }
        int leftPoint = 0;
        int rightPoint = cleanString.length() - 1;

        while (rightPoint > leftPoint) {
            if (cleanString.charAt(leftPoint) != cleanString.charAt(rightPoint)) {
                return false;
            }
            leftPoint++;
            rightPoint--;
        }
        return true;
    }
}
