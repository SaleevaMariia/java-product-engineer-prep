package algorithms.string;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int currentIndex = s.charAt(i) - 'a';
            counts[currentIndex]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int currentIndex = s.charAt(i) - 'a';
            if (counts[currentIndex] == 1) {
                return i;
            }
        }
        return -1;
    }
}
