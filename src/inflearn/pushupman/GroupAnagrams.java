package inflearn.pushupman;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
    }

    /**
     * 같은 문자열을 가진 애들을 묶어서 정렬하라
     */
    public static List<List<String>> groupAnagrams(String[] strs){

        //1 structure
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        //2 for while
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
