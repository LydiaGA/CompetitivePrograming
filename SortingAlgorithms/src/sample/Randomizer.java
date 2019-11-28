package sample;

import java.util.Random;

public class Randomizer {
//    public static void main(String[] args) {
//        int[] randomArray = getRandomOrder();
//        for (int value : randomArray) {
//            System.out.print(value + ", ");
//        }
//    }
    public static int[] getRandomOrder(){
        int[] randomArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            randomArray[i] = i;
        }

        for (int i = 0; i < 10000; i++) {
            Random r = new Random();

            int firstIndex= r.nextInt(10000);
            System.out.println(firstIndex);
            int secondIndex= r.nextInt(10000);
            System.out.println(secondIndex);

            int temp = randomArray[firstIndex];
            randomArray[firstIndex] = randomArray[secondIndex];
            randomArray[secondIndex] = temp;
        }

        return randomArray;
    }
}
