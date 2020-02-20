package main;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastK {
    List<Integer> products;
    List<Integer> numbers;
    public ProductOfLastK() {
        products = new ArrayList<>();
        numbers = new ArrayList<>();
    }

    public void add(int num) {
        if(num == 0){
            numbers = new ArrayList<>();
            products = new ArrayList<>();
        }else{
            if(numbers.size() == 0){
                products.add(num);
            }else{
                products.add(products.get(numbers.size() - 1) * num);
            }

            numbers.add(num);
        }
    }

    public int getProduct(int k) {
        int size = numbers.size();
        if(k > size){
            return 0;
        }else if(k == size){
            return products.get(size - 1);
        }
        int result = products.get(size - 1) / products.get(size - k - 1);
        return result;
    }
}
