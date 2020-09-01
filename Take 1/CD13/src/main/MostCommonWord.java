package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
	// write your code here
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordOccurences = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        String[] parArr = paragraph.split(" ");
        int max = 0;
        String result = "";
        for(int i = 0; i < banned.length; i++){
            bannedSet.add(banned[i]);
        }

        for(int i = 0; i < parArr.length; i++){
            String[] wordArr = parArr[i].split(",");
            for(int j = 0; j < wordArr.length; j++){
                String word = wordArr[j];
                int wordSize = wordArr[j].length();
                if((word.charAt(wordSize - 1) > 90 && word.charAt(wordSize - 1) < 97) || word.charAt(wordSize - 1) < 65 || word.charAt(wordSize - 1) > 122){
                    word = word.substring(0, wordSize - 1);
                }
                word = word.toLowerCase();

                if(bannedSet.contains(word)){
                    continue;
                }

                if(wordOccurences.containsKey(word)){
                    wordOccurences.replace(word, wordOccurences.get(word) + 1);
                }else{
                    wordOccurences.put(word, 1);
                }

                if(wordOccurences.get(word) > max){
                    max = wordOccurences.get(word);
                    result = word;
                }
            }

        }

        return result;
    }
}
