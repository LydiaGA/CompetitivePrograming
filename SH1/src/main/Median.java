package main;

import java.util.Arrays;

public class Median {

    public static void main(String[] args) {
	// write your code here
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        if(merged.length % 2 != 0){
            return merged[(int)Math.floor((float) merged.length / 2)];
        }else{
            return (float) (merged[merged.length / 2] + merged[(merged.length / 2) - 1]) / 2;
        }

    }

    int[] merge(int[] nums1, int[] nums2){
        int[] merged = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0, counter = 0;
        while(i1 < nums1.length || i2 < nums2.length){
            if(i1 >= nums1.length){
                merged[counter] = nums2[i2];
                i2++;
                counter++;
                continue;
            }
            if(i2 >= nums2.length){
                merged[counter] = nums1[i1];
                i1++;
                counter++;
                continue;
            }

            int min = Math.min(nums1[i1], nums2[i2]);
            merged[counter] = min;
            if(min == nums1[i1]){
                i1++;
            }else{
                i2++;
            }
            counter++;
        }

        System.out.println(Arrays.toString(merged));
        return merged;
    }
}
