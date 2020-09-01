package Daily;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int previous = flowerbed[0];
        if(flowerbed[0] == 0 && (flowerbed.length == 1 || flowerbed[1] == 0)){
            previous = 1;
            n -= 1;
        }

        for(int i = 1; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && previous == 0 && (i == flowerbed.length -1 || flowerbed[i + 1] == 0)){
                previous = 1;
                n -= 1;
            }else{
                previous = flowerbed[i];
            }

            if(n <= 0){
                return true;
            }
        }

        return n <= 0;
    }
}
