package main;

public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int firstPtr = 0, secondPtr = 0;
        int cost = 0;
        int maxLength = 0;

        while(secondPtr <= sArr.length){
            if(cost > maxCost){
                cost -= Math.abs(sArr[firstPtr] - tArr[firstPtr]);
                firstPtr++;
            }else{
                if(secondPtr - firstPtr > maxLength){
                    maxLength = secondPtr - firstPtr;
                }
                if(secondPtr != sArr.length){
                    cost += Math.abs(sArr[secondPtr] - tArr[secondPtr]);
                }
                secondPtr++;
            }

        }

        if(firstPtr == 0 && secondPtr == sArr.length && cost < maxCost){
            return sArr.length;
        }

        return maxLength;
    }
}
