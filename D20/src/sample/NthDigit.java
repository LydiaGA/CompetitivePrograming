package sample;

public class NthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
    }
    public static int findNthDigit(int n) {
        int level = 1;
        long lastLevelEnd = 0, lastLevelCount = 0, currentLevelCount = 9;
        while(n > currentLevelCount){
            long tempLevelEnd = lastLevelEnd;
            lastLevelEnd = (lastLevelEnd * 10) + 9;
            lastLevelCount = ((lastLevelEnd - tempLevelEnd) * level) + lastLevelCount;
            currentLevelCount = ((((lastLevelEnd * 10) + 9) - lastLevelEnd) * (level + 1)) + currentLevelCount;
            System.out.println(currentLevelCount + " "+ level);
            level++;
        }

        //System.out.println(lastLevelEnd + " " + lastLevelCount + " " + level);
        long digitsAfterLastLevelEnd = n - lastLevelCount;
        long integerWithNthDigit = lastLevelEnd + (int) Math.ceil((double)(digitsAfterLastLevelEnd) / level);
        int index = ((int)digitsAfterLastLevelEnd - 1) % level;

        //System.out.println(integerWithNthDigit + " " + index);

        String integerString = Integer.toString((int) integerWithNthDigit);

        return Integer.parseInt(integerString.split("")[index]);
    }
}
