package sample;

public class HIndexII {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0, 1, 5, 6, 7, 8, 9}));
    }

    public static int hIndex(int[] citations) {
        int min = 0, max = citations.length - 1, mid;
        int h_index = 0, h;
        while(min <= max){
            mid = min + (max - min) / 2;
            h = citations.length - mid;
            if(citations[mid] >= h){
                h_index = h;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return h_index;
    }
}
