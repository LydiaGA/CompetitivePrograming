package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
    public static void main(String[] args) {
        int[] result = intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    boolean test = inArray(result, nums1[i]);
                    if(!test){
                        result.add(nums1[i]);
                    }
                }
            }
        }

        int toReturn[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            toReturn[i] = result.get(i);
        }

        return toReturn;
    }

    static boolean inArray(ArrayList<Integer> array, int value){
        boolean test = false;
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) == value){
                test  = true;
            }
        }

        return test;
    }
}
