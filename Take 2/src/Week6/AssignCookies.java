package Week6;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int j = 0;
        for(int i = 0; i < g.length; i++){
            while(j < s.length){
                if(s[j] >= g[i]){
                    result += 1;
                    j++;
                    break;
                }
                j++;
            }

            if(j == s.length){
                break;
            }
        }

        return result;
    }
}
