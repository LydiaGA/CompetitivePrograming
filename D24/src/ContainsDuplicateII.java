import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            if (set.size() < k) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i - k]);
                set.add(nums[i]);
            }
        }

        return false;
    }
}
