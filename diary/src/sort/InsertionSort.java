package sort;

/*
삽입 정렬
시간 복잡도 : O(n^2)

선택한 요소를 이미 정렬된 배열 부분의 적절한 위치에 삽입
배열을 순회하면서 뒤에게 작으면 계속 앞으로 보낸다.
 */
public class InsertionSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,9,4,8,7};
    printArray(array);
    insertionSort(array);
    printArray(array);
  }

  public static void insertionSort(int[] array) {
    int n = array.length;

    for(int i = 1; i < n; i++) {
      int key = array[i];
      int j = i - 1;

      // key 보다 큰 array[j]를 한 위치 뒤로 이동 (작은 값을 앞으로 이동)
      while(j >= 0 && array[j] > key) {
        array[j+1] = array[j];
        j = j - 1;
      }
      array[j+1] = key;
    }
  }

  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
