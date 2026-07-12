package algorithms.string;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }
        for (int letter : letters) {
            if (letter != 0)
                return false;
        }
        return true;
    }
}
