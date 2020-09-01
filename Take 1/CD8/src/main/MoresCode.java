package main;

import java.util.HashSet;
import java.util.Set;

public class MoresCode {\public int uniqueMorseRepresentations(String[] words) {
    String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    Set<String> uniqueCodes = new HashSet<>();
    String wordCode;
    for(int i = 0; i < words.length; i++){
        wordCode = "";
        for(int j = 0; j < words[i].length(); j++){
            String word = words[i];
            wordCode += codes[word.charAt(j) - 97];
        }

        uniqueCodes.add(wordCode);
    }

    return uniqueCodes.size();
}
}
