package sample;

import java.util.ArrayList;

public class Tribonacci {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        System.out.println(tribonacci(37, list));
    }

    public static int tribonacci(int n, ArrayList<Integer> list) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if (n == 2) return 1;

        int l = list.size() - 1;
        if (l < n) {
            list.add(list.get(l) + list.get(l - 1) + list.get(l - 2));
            tribonacci(n, list);
        }

        return list.get(list.size() - 1);
    }
}
