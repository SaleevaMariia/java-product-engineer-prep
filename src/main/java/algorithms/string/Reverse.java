package algorithms.string;

public class Reverse {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word: words){
            for (int i = word.length() - 1; i >=0; i--){
                result.append(word.charAt(i));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
