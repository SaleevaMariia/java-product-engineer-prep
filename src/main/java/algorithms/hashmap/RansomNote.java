package algorithms.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct2("a", "ab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character temp = magazine.charAt(i);
            charToCount.put(temp, charToCount.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character temp = ransomNote.charAt(i);
            if (charToCount.containsKey(temp)) {
                charToCount.put(temp, charToCount.get(temp) - 1);
                if (charToCount.get(temp) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character temp = magazine.charAt(i);
            charToCount.put(temp, charToCount.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character temp = ransomNote.charAt(i);
            if (charToCount.containsKey(temp)) {
                int count = charToCount.get(temp);
                charToCount.put(temp, count - 1);
                if (count - 1 < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
