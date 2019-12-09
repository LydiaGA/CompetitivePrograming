package sample;

public class SortColors {

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums){
        if(nums.length == 0){
            return;
        }

        int max = getMax(nums);

        int[] count = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
        }

        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[counter] = i;
                counter++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static int getMax(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }
}
