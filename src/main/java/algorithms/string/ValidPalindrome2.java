package algorithms.string;

import java.util.Locale;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    //O(n) + O(1) - Память
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT);
        int leftPoint = 0;
        int rightPoint = s.length() - 1;

        while (rightPoint > leftPoint) {
            char tempLeft = s.charAt(leftPoint);
            char tempRight = s.charAt(rightPoint);
            if (!Character.isLetterOrDigit(tempLeft)) {
                leftPoint++;
                continue;
            }
            if (!Character.isLetterOrDigit(tempRight)) {
                rightPoint--;
                continue;
            }
            if (tempLeft != tempRight) {
                return false;
            }
            leftPoint++;
            rightPoint--;
        }
        return true;
    }
}
