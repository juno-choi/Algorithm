package back;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class M7 {
    /*
     * Complete the 'getMaxElementIndexes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY rotate
     */
    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        List<Integer> rotate = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(4);
        a.add(3);

        rotate.add(0);
        rotate.add(2);

        List<Integer> maxElementIndexes = getMaxElementIndexes(a, rotate);
        for(int i : maxElementIndexes){
            System.out.println(i);
        }
    }

    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
        // Write your code here
        // max값 찾기
        int max = a.stream().mapToInt(i->i).max().orElse(0);

        // list 만들기
        List<Integer> maxElementIndexes = new ArrayList<>();
        List<Queue<Integer>> queList = new ArrayList<>();
        for(int r : rotate){
            Queue<Integer> que = new LinkedList<>(a);
            for(int i=0; i<r; i++){
                Integer poll = que.poll();
                que.add(poll);
            }
            queList.add(que);
        }

        // list에서 max값 찾기
        for(Queue<Integer> q : queList){
            List<Integer> list = q.stream().collect(Collectors.toList());
            maxElementIndexes.add(list.indexOf(max));
        }

        return maxElementIndexes;
    }

}
