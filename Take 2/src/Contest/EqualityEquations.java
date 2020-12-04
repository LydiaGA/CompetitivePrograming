package Contest;

import java.util.*;

public class EqualityEquations {
    public boolean equationsPossible(String[] equations) {
        List<Set<Character>> equalList = new ArrayList<>();
        for (String current : equations) {
            if (current.charAt(1) == '=') {
                List<Set<Character>> found = new ArrayList<>();
                for (int j = 0; j < equalList.size(); j++) {
                    Set<Character> s = equalList.get(j);
                    if (s.contains(current.charAt(0)) || s.contains(current.charAt(3))) {
                        found.add(s);
                        s.add(current.charAt(0));
                        s.add(current.charAt(3));
                    }

                    if (found.size() > 1) {
                        found.get(0).addAll(found.get(1));
                        equalList.remove(j);
                    }
                }

                if (found.size() == 0) {
                    equalList.add(new HashSet<>(Arrays.asList(current.charAt(0), current.charAt(3))));
                }
            }
        }

        for (String current : equations) {
            if (current.charAt(1) == '!') {
                for (Set s : equalList) {
                    if (current.charAt(0) == current.charAt(3) || (s.contains(current.charAt(0)) && s.contains(current.charAt(3)))) {
                        return false;
                    }
                }
            }
        }

        return true;

    }
}
