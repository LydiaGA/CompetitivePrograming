package main;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        System.out.println(s.length());
        long occurenceOfA = findOccurenceOfA(s);
        long q = n / s.length();
        long r = n % s.length();
        long occurenceInRemaining = findOccurenceOfA(s.substring(0, (int) r));
        return (occurenceOfA * q) + occurenceInRemaining;
    }

    static long findOccurenceOfA(String s){
        long occurence = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                occurence++;
            }
        }

        return occurence;
    }
}
