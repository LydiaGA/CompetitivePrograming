package sample;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        String splitS[] = s.split("");
        String splitT[] = t.split("");

        if(splitS.length != splitT.length){
            return false;
        }

        Arrays.sort(splitS);
        Arrays.sort(splitT);

        return Arrays.equals(splitS, splitT);
    }
}
