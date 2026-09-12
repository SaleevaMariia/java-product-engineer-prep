package algorithms.stack;

public class RemoveAllDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!result.isEmpty()){
                if(result.charAt(result.length()-1) == s.charAt(i)){
                    result.deleteCharAt(result.length()-1);
                    continue;
                }
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
