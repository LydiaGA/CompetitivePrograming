package main;

import java.util.Arrays;

public class NumberOfLines {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa")));
    }

    public static int[] numberOfLines(int[] widths, String S) {
        int lines = 0;
        int lineWidth = 0;
        for(int i = 0; i < S.length(); i++){
            int currentLineWidth = lineWidth + widths[S.charAt(i) - 97];
            if(currentLineWidth > 100){
                System.out.println(currentLineWidth);
                lines++;
                lineWidth = widths[S.charAt(i) - 97];
                continue;
            }
            lineWidth = currentLineWidth;
        }

        return new int[]{lines + 1, lineWidth};
    }
}
