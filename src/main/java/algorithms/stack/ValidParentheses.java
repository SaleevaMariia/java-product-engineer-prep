package algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    // Time Complexity: O(n)
   // Space Complexity: O(n)

    public static boolean isValid(String s) {
        Deque<Character> parentheses = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            switch (temp){
                case '(', '{', '[' -> parentheses.push(temp);
                case ')' -> { if (parentheses.isEmpty() ||  parentheses.pop() != '(') return false;}
                case ']' -> { if (parentheses.isEmpty() ||  parentheses.pop() != '[') return false;}
                case '}' -> { if (parentheses.isEmpty() ||  parentheses.pop() != '{') return false;}
            }
        }
        return parentheses.isEmpty();
    }

}
