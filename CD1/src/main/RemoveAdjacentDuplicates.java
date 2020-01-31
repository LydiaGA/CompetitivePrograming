package main;

public class RemoveAdjacentDuplicates {

    public String removeDuplicates(String s, int k) {
        boolean didRemove = true, isEqual;
        while(didRemove){
            didRemove = false;
            for(int i = 0; i < s.length() - (k - 1); i++){
                isEqual = true;
                for(int j = i + 1; j < i + k; j++){
                    if(s.charAt(j) != s.charAt(i)){
                        isEqual = false;
                        break;
                    }
                }

                System.out.println(isEqual);

                if(isEqual){
                    s = s.substring(0, i) + s.substring(i + k, s.length());
                    didRemove = true;
                }
            }
        }

        return s;
    }
}
