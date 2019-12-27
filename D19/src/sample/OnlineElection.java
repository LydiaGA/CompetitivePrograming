package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
    public static void main(String[] args) {

    }
}

class TopVotedCandidate {

    int[] persons, times;
    Map<Integer, Integer> timesDictionary;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;

       timesDictionary = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            timesDictionary.put(i, getLeading(i));
        }
    }

    public int q(int t) {
        int index = getTimeIndex(t);
        return timesDictionary.get(index);
    }

    int getTimeIndex(int time){
        int min = 0, max = times.length - 1, mid;
        int result = 0;
        while(min <= max){
            mid = min + (max - min) / 2;
            if(times[mid] <= time){
                result = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return result;
    }

    int getLeading(int index){
        int maxPerson = persons[getMax(persons, index).get(0)];
        int[] counts = new int[persons.length];
        for (int i = 0; i <= index; i++) {
            counts[persons[i]] ++;
        }

        ArrayList<Integer> leading = getMax(counts, counts.length - 1);
        if(leading.size() == 1){
            return leading.get(0);
        }else{
            for (int i = index; i >= 0; i--) {
                for (int j = 0; j < leading.size(); j++) {
                    if(persons[i] == leading.get(j)){
                        return persons[i];
                    }
                }
            }
        }

        return -1;
    }

    ArrayList<Integer> getMax(int[] nums, int index){
        int max = nums[0];
        ArrayList<Integer> ties = new ArrayList<>();
        for (int i = 0; i <= index; i++) {
            if(nums[i] == max){
                ties.add(i);
            }else if (nums[i] > max){
                max = nums[i];
                ties = new ArrayList<>();
                ties.add(i);
            }
        }

        return ties;
    }
}
