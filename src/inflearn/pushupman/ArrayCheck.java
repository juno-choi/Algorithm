package inflearn.pushupman;

import java.util.Arrays;

public class ArrayCheck {
    /**
     * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지 확인하려합니다.
     * 1부터 n까지 숫자가 중복 없이 한번씩 들어 있는 경우 true, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
     */
    public static void main(String[] args) {
        boolean res = solution2(new int[]{4,1,3,2});
        System.out.println(res);
    }
    public static boolean solution1(int[] arr){
        boolean answer = true;
        int[] check = new int[100001];

        //배열의 크기
        int size = arr.length;
        //배열의 크기만큼 순서대로 정렬되어있는지 확인
        for(int i=0; i<size; i++){
            //배열의 값
            int arr_val = arr[i]-1;
            //배열의 값을 check 배열에 표시해줌
            check[arr_val] += 1;
            //중복된 값이 들어가는 순간 검사 종료
            if(check[arr_val] > 1){
                return false;
            }
        }

        //check 배열에 모두 표시했으므로 check배열을 for문을 돌려서 확인
        for(int i=0; i<size; i++){
            if(check[i]!=1){
                return false;
            }
        }
        
        return answer;
    }
    public static boolean solution2(int[] arr){
        boolean answer = true;
        //java Arrays class method sort 사용
        Arrays.sort(arr);
        int a = 1;
        //향상된 for문을 이용하여 arr의 정렬이 순차적인지 검사
        for(int n : arr){
            if(n != a){
                //순차적이지 않은 값이 있다면 검사 종료
                return false;
            }
            a++;
        }
        return answer;
    }
}
