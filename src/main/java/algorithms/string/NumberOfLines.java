package algorithms.string;

import java.util.Arrays;

public class NumberOfLines {
    public static void main(String[] args) {
        int[] widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        System.out.println(Arrays.toString(numberOfLines(widths, s)));
    }
    public static int[] numberOfLines(int[] widths, String s) {
        int sum = 0;
        int rows = 1;
        for (int i = 0; i < s.length(); i++){
            int currentWidth = widths[s.charAt(i)-'a'];
            if (sum + currentWidth > 100){
                sum = currentWidth;
                rows++;
            }else {
                sum+=currentWidth;
            }
        }
        return new int[]{rows, sum};
    }
}
