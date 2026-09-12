package algorithms.stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        System.out.println(backspaceCompare(s, t));
    }

    //Time Complexity: O(n + m)
   // Space Complexity: O(n + m)

    public static boolean backspaceCompare(String s, String t) {
        return buildCleanString(s).equals(buildCleanString(t));
    }

    private static String buildCleanString(String str) {
        StringBuilder clean = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current != '#') {
                clean.append(current);
            } else if (!clean.isEmpty()) {
                clean.deleteCharAt(clean.length() - 1);
            }
        }

        return clean.toString();
    }
}
