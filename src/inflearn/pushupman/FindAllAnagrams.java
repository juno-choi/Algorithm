package inflearn.pushupman;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    /**
     * 아스키 코드 값으로 비교한다.
     */
    public static void main(String[] args) {
        FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(findAllAnagrams.findAnagrams(txt, pat));
    }

    public List<Integer> findAnagrams(String txt, String pat){
        //structure
        List<Integer> result = new ArrayList<>();
        if(txt == null || txt.length() ==0 || pat==null || pat.length() == 0|| txt.length()<pat.length()){
            return result;
        }
        //for, while
        int[] patArr = new int[256];    //[0,0,0,0,0...1,1,1,1,0,0,0,0,0...] A,B,C,D 의 아스키코드 위치인 65,66,67,68이 1로 하여 값을 비교함
        for(int i=0; i<pat.length(); i++){  //배열의 아스키 코드값 위치를 1로 변경해줌
            patArr[pat.charAt(i)]++;
        }

        for(int i=0; i<txt.length()-pat.length()+1; i++){
            int[] txtArr = new int[256];
            for(int j=0; j<pat.length(); j++){
                txtArr[txt.charAt(i+j)]++;  //i가 0일 경우 0123, 1일 경우 1234 ...
            }

            if(check(patArr, txtArr)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(int[] patArr, int[] txtArr){
        for(int i=0; i<patArr.length; i++){
            if(patArr[i] != txtArr[i]) return false;
        }
        return true;
    }
}
