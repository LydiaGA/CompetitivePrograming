import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public static void main(String[] args) {

    }

    public List<String> commonChars(String[] A) {
        Map<String, Integer> first = new HashMap<>();
        Map<String, Integer> second = new HashMap<>();

        String[] firstInput = A[0].split("");
        for (int i = 0; i < firstInput.length; i++) {
            if(first.containsKey(firstInput[i])){
                first.replace(firstInput[i], first.get(firstInput[i]) + 1);
            }else{
                first.put(firstInput[i], 1);
            }
        }

        for (int i = 1; i < A.length; i++) {
            String[] input = A[i].split("");
            for (int j = 0; j < input.length; j++) {
                if(first.containsKey(input[j])) {
                    if (!second.containsKey(input[j])) {
                        second.put(input[j], 1);
                    } else if (second.get(input[j]) < first.get(input[j])) {
                        second.replace(input[j], second.get(input[j]) + 1);
                    }
                }
            }
            first = second;
            second = new HashMap<>();
        }

        List<String> result = new ArrayList<>();

        for (String s : first.keySet()) {
            for (int i = 0; i < first.get(s); i++) {
                result.add(s);
            }
        }

        return result;
    }
}
