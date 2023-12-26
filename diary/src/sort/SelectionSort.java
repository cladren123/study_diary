package sort;

/*
선택 정렬(Selection Sort)
시간 복잡도 : O(n^2)
가장 작은 값을 찾은 다음 첫 번째 인덱스에 넣는다.
이 과정을 처음부터 끝까지 반복하여 정렬을 완성한다.
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,9,4,8,7};
    printArray(array);
    selectionSort(array);
    printArray(array);
  }

  // 선택 정렬 시작
  public static void selectionSort(int[] array) {
    selectionSort(array, 0);
  }

  // 선택 정렬 로직 수행
  public static void selectionSort(int[] array, int start) {
    if(start < array.length-1) {

      // 작은 인덱스 탐색
      int min_index = start;
      for(int i = start; i < array.length; i++) {
        if(array[i] < array[min_index]) min_index = i;
      }

      // 탐색한 작은 인덱스를 맨 앞에 인덱스랑 교환
      swap(array, start, min_index);

      // 다음 인덱스의 값 탐색
      selectionSort(array, start + 1);
    }
  }

  public static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
