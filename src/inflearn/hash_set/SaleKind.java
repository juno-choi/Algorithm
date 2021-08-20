package inflearn.hash_set;

import java.util.*;

/**
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 *
 * 각 구간별로 구하라고 했습니다.
 *
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 *
 * 20 12 20 10 23 17 10
 *
 * 각 연속 4일간의 구간의 매출종류는
 *
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 *
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 *
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 *
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 *
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 */
public class SaleKind {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        int input2 = in.nextInt();

        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }

        /*int[] solution = solution(input1, input2, arr);
        for (int i : solution) {
            System.out.print(i+" ");
        }*/
        ArrayList<Integer> integers = solution2(input1, input2, arr);
        for (Integer integer : integers) {
            System.out.print(integer+" ");
        }
    }
    public static int[] solution(int n, int m, int[] arr){
        int[] answer = new int[(n-m)+1];
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<m; i++){
            list.add(arr[i]);
        }
        for(int i : list){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        answer[0] = map.size();

        //이후에 sliding window 알고리즘을 통해 값 넣어주기
        int idx = 1;
        for(int rp = m; rp<arr.length; rp++){
            int key = list.get(0);
            int value = map.get(key);
            if(value == 1){
                map.remove(key);
            }else{
                map.put(key, map.get(key)-1);
            }
            list.remove(0);
            list.add(arr[rp]);
            map.put(arr[rp],map.getOrDefault(arr[rp],0)+1);
            answer[idx++] = map.size();
        }
        return answer;
    }

    public static ArrayList<Integer> solution2(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int lt = 0;
        for(int rt = k-1; rt<n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt],0)+1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt])==0) map.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
}
