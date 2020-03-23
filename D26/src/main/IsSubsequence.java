package main;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        if(t.length() == 0){
            return false;
        }
        char current = s.charAt(0);

        int j = 0;
        boolean result = false;
        for(int i = 0; i < t.length(); i++){
            if(current == t.charAt(i)){

                if(j == s.length() - 1){
                    result = true;
                    break;
                }
                j++;
                current = s.charAt(j);
            }else{
                result = false;
            }
        }

        return result;
    }
}
