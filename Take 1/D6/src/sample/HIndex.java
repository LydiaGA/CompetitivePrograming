package sample;

public class HIndex {
    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        int[] sorted = sort(citations);
        for (int i = sorted.length - 1; i >= 0; i--) {
            int h = sorted.length - i;
            if(citations[i] == h){
                return h;
            }else if(citations[i] < h){
                break;
            }
        }

        return citations.length;
    }

     static int[] sort(int[] nums){
        if(nums.length == 0){
            return new int[]{};
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

        return nums;
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
