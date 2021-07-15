package search;

/**
 * 이진 탐색
 */
public class BinarySearch {
    public void binarySearch(int arr[], int key) {
        int mid;
        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            mid = (right + left) / 2;

            if (key == arr[mid]) {
                System.out.println("key = "+ key + ", array index = " + mid+", value = "+arr[mid]);
                break;
            }

            if (key < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
    }
}
