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
    int[][] counts;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;

        int maxPerson = getMax(persons, persons.length - 1);
        counts = new int[maxPerson + 1][2];

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
        counts[index][0] ++;
        counts[index][1] = index;

        int leading = getMaxVotes(counts, counts.length - 1);

        return leading;
    }

    int getMaxVotes(int[][] nums, int index){
        int[] max = nums[0];
        int leading = 0;
        for (int i = 0; i <= index; i++) {
            if (nums[i][0] > max[0]){
                max = nums[i];
                leading = i;
            }else if(nums[i][0] == max[0]){
                if(nums[i][1] > max[1]){
                    max = nums[i];
                    leading = i;
                }
            }

        }

        return leading;
    }

    int getMax(int[] nums, int index){
        int max = nums[0];
        for (int i = 0; i <= index; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }

        return max;
    }
}
