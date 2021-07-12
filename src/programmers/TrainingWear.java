package programmers;

import java.util.Arrays;

/**
 * 문제 설명
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 * 입출력 예
 * n	lost	reserve	return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	4
 * 3	[3]	[1]	2
 * 입출력 예 설명
 * 예제 #1
 * 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
 *
 * 예제 #2
 * 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
 */
public class TrainingWear {
    public static void main(String[] args) {
        TrainingWear trainingWear = new TrainingWear();
        int n = 5;
        int[] lost = {4,5};
        int[] reserve = {3,4};
        int solution = trainingWear.solution(n, lost, reserve);
        System.out.println("solution = " + solution);
    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //최대 값인 n에서 lost의 길이만큼 뺀다 = 최소값으로 초기화
        answer = n-lost.length;

        //자신이 잃어버렸을 때 먼저 제거
        Arrays.sort(reserve);
        int idx = 0;
        for(int r : reserve){
            int search = search(lost, r);
            if(search >= 0){
                lost[search] = -1;
                reserve[idx] = -1;
                answer++;
                idx++;
                continue;
            }
            idx++;
        }
        Arrays.sort(reserve);

        for(int i=0; i<reserve.length; i++){
            int r = reserve[i];
            if(r==-1) continue;
            Arrays.sort(lost);
            //앞에 빌려줄 때
            int search = 0;
            search = search(lost, r-1);
            if(search >= 0){
                lost[search] = -1;
                reserve[i] = -1;
                answer++;
                continue;
            }
            //뒤에 빌려줄 때
            search = search(lost, r+1);
            if(search >= 0){
                lost[search] = -1;
                reserve[i] = -1;
                answer++;
                continue;
            }
            //빌려주지 못하는 경우
            reserve[i] = -1;
        }
        return answer;
    }

    private int search(int[] arr, int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    /**
     * arr에 들어가는 배열은 sort되어 있어야함
     * arrLength는 배열의 길이
     * key 값을 찾아서 idx 값을 return
     * return이 -1일 경우 값을 찾지 못한 경우
     */
    private int binarySearch(int[] arr, int key){
        //배열을 확인
        int left = 0;
        int right =arr.length-1;
        int mid = 0;

        while(left<=right){
            mid = (left+right)/2;

            if(arr[mid] == key){
                return mid;
            }

            if(arr[mid] < key){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
