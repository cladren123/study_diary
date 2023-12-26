package sort;

/*
버블 정렬
시간 복잡도 : O(n^2)
앞에서부터 2개씩 값을 비교하면서 작은 값을 앞으로 큰 값을 뒤로 보낸다.
한 번 선형 반복할 때 마다 마지막의 값이 정렬된 값을 가진다.
이 과정을 끝까지 반복해서 정렬을 하는 방법이다.

참고 자료 : https://www.youtube.com/watch?v=YbsQiiubO74
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,9,4,8,7};
    printArray(array);
    bubbleSort(array);
    printArray(array);
  }

  // 버블 정렬 시작
  public static void bubbleSort(int[] array) {
    bubbleSort(array, array.length-1);
  }

  // 버블 정렬 로직 수행
  public static void bubbleSort(int[] array, int last) {
    // 마지막 인덱스가 0보다 클 때까지 반복 (마지막부터 정렬된다.)
    if(last > 0) {

      // 반복을 하면 마지막 인덱스는 정렬이 된다.
      for(int i = 1; i <= last; i++) {
        if(array[i-1] > array[i]) {
          swap(array, i-1, i);
        }
      }

      // 마지막은 정렬되었기에 last - 1을 정렬하기 위해 last - 1을 입력
      bubbleSort(array, last - 1);

    }
  }

  public static void swap(int array[], int source, int target) {
    int temp = array[source];
    array[source] = array[target];
    array[target] = temp;
  }



  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
