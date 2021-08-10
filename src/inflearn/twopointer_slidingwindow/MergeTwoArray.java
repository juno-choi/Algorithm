package inflearn.twopointer_slidingwindow;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 */
public class MergeTwoArray {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr1 = new int[input1];
        for(int i=0; i<input1; i++){
            arr1[i] = in.nextInt();
        }
        int input2 = in.nextInt();
        int[] arr2 = new int[input2];
        for(int i=0; i<input2; i++){
            arr2[i] = in.nextInt();
        }

        ArrayList<Integer> solution = solution3(arr1, arr2);
        for (int i : solution) {
            System.out.print(i+" ");
        }
    }
    public static ArrayList<Integer> solution(int[] arr1, int[] arr2){
        //배열의 길이를 만들어 배열을 만들고
        int length1 = arr1.length;
        int length2 = arr2.length;
        int length = length1 + length2;
        ArrayList<Integer> list = new ArrayList<>();
        //배열을 반복문을 통해 두 포인터의 값으로 반복하여 값을 빼낸다.
        int p1 = 0;
        int p2 = 0;

        while(list.size() < length){
            if(p1 == length1){
                int su2 = arr2[p2];
                list.add(su2);
                p2++;
            }else if(p2 == length2){
                int su1 = arr1[p1];
                list.add(su1);
                p1++;
            }else {
                int su1 = arr1[p1];
                int su2 = arr2[p2];
                if (su1 < su2) {
                    list.add(su1);
                    p1++;
                } else {
                    list.add(su2);
                    p2++;
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> solution2(int[] arr1, int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();
        int p1=0;
        int p2=0;
        while(p1<arr1.length && p2<arr2.length){
            if(arr1[p1]<arr2[p2]) list.add(arr1[p1++]);
            else list.add(arr2[p2++]);
        }
        while(p1<arr1.length) list.add(arr1[p1++]);
        while(p2<arr2.length) list.add(arr2[p2++]);

        return list;
    }

    public static ArrayList<Integer> solution3(int[] arr1, int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr1){
            list.add(i);
        }
        for(int i : arr2){
            list.add(i);
        }
        list.sort((o1, o2) -> {
            if(o1>o2) return 1;
            else return -1;
        });
        return list;
    }
}
