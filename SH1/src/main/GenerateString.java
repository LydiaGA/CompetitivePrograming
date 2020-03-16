package main;

public class GenerateString {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 0 || n == 1){
            for(int i = 0; i < n - 1; i++){
                sb.append("a");
            }
            sb.append("b");
        }else{
            for(int i = 0; i < n - 2; i++){
                sb.append("a");
            }
            sb.append("b");
            sb.append("c");
        }

        return sb.toString();
    }
}
