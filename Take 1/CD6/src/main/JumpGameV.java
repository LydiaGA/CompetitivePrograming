package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpGameV {
    public int maxJumps(int[] arr, int d) {
        Map<Integer, Integer> resultTable = new HashMap<>();
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            int currentResult = jump(arr, d, i, resultTable);
            if(currentResult > max){
                max = currentResult;
            }
        }

        return max;
    }

    int jump(int[] arr, int d, int index, Map<Integer, Integer> resultTable){
        if(resultTable.containsKey(index)){
            return resultTable.get(index);
        }

        int max = 0;
        int numOfMoves = 0;
        List<Integer> moves = getMoves(arr, d, index);
        for(int move : moves){
            numOfMoves = jump(arr, d, move, resultTable);
            if(numOfMoves > max){
                max = numOfMoves;
            }
        }

        resultTable.put(index, 1 + max);
        return 1 + max;
    }

    List<Integer> getMoves(int[] arr, int d, int start){
        List<Integer> moves = new ArrayList<>();

        if(start != arr.length - 1){
            int max = arr[start + 1];
            for(int i = 1; i <= d; i++){
                int currentMove = start + i;
                if(currentMove >= arr.length){
                    continue;
                }else{
                    if(arr[currentMove] < arr[start] && arr[currentMove] >= max){
                        moves.add(currentMove);
                    }
                    if(arr[currentMove] >= max){
                        max = arr[currentMove];
                    }
                }
            }
        }

        if(start != 0){
            int max = arr[start - 1];
            for(int i = 1; i <= d; i++){
                int currentMove = start - i;
                if(currentMove < 0){
                    continue;
                }else{
                    if(arr[currentMove] < arr[start] && arr[currentMove] >= max){
                        moves.add(currentMove);
                    }
                    if(arr[currentMove] >= max){
                        max = arr[currentMove];
                    }
                }

            }
        }

        return moves;
    }
}
