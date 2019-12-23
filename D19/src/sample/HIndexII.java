package sample;

public class HIndexII {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0, 1, 5, 6, 7, 8, 9}));
    }

    public static int hIndex(int[] citations) {
        int min = 0, max = citations.length - 1, mid;
        int zeros = 0;
        int h_index = citations.length;
        while(min <= max){
            if(citations[min] == 0){
                min++;
                zeros++;
                continue;
            }
            mid = min + (max - min) / 2;
            int h = citations.length - mid;
            if(citations[mid] >= h){
                if (citations[mid] < h_index){
                    h_index = citations[mid];
                }
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return h_index;
    }
}
