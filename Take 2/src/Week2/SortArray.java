package Week2;

public class SortArray {
    public int[] sortArray(int[] nums) {
        int[] sorted = new int[nums.length];
        int[] maxMinRes = getMaxMin(nums);
        int max = maxMinRes[0];
        int min = maxMinRes[1];

        int[] countPos = new int[max + 1];
        int[] countNeg;
        if (min < 0) {
            countNeg = new int[(min * -1) + 1];
        }else{
            countNeg = new int[0];
        }


        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                countNeg[nums[i] * -1] += 1;
            }else{
                countPos[nums[i]] += 1;
            }
        }

        int counter = 0;
        for (int i = countNeg.length - 1; i >= 0; i--) {
            for (int j = 0; j < countNeg[i]; j++) {
                sorted[counter] = i * -1;
                counter++;
            }
        }
        for (int i = 0; i < countPos.length; i++) {
            for (int j = 0; j < countPos[i]; j++) {
                sorted[counter] = i;
                counter++;
            }
        }

        return sorted;
    }

    int[] getMaxMin(int[] array){
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }

        return new int[]{max, min};
    }
}
