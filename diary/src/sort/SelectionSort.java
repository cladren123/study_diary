package sort;

/*
선택 정렬
O(n^2)
가장 작은 값부터 앞부터 채워넣는 방식
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
