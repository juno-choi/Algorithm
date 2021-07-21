package programmers;

public class StringDesc {

    public static void main(String[] args) {
        StringDesc sd = new StringDesc();
        String s = "Zcbdefg";
        String solution = sd.solution(s);
        System.out.println("solution = " + solution);
    }

    public String solution(String s) {
        char[] chars = s.toCharArray();
        mergeSort(chars,0, chars.length-1);
        String answer = "";
        for(char c : chars){
            answer += c;
        }
        return answer;
    }

    private void mergeSort(char[] array, int low, int high){
        if (high <= low)
            return;
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(char[] array, int low, int mid, int high){
        char leftArray[] = new char[mid - low + 1];
        char rightArray[] = new char[high - mid];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];

        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++)
        {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length)
            {
                if (leftArray[leftIndex] >= rightArray[rightIndex]) // < : ascending, >=descending
                {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else
                {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < leftArray.length)
            {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < rightArray.length)
            {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
