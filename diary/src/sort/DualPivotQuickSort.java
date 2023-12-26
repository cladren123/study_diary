package sort;


/*
듀얼 피봇 퀵소트 Dual Pivot Quick Sort

시간 복잡도
평균        - O(n log n)
최악의 경우  - O(n^2)

Java의 sort 메소드에서 프리미티브 타입의 배열을 정려할 때 사용
두 개의 피벗을 선택하여 3개의 영역으로 나눈 후 정렬을 진행한다.
퀵소트보다 효율적이다.
 */
public class DualPivotQuickSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,9,4,8,7};
    printArray(array);
    dualPivotQuickSort(array);
    printArray(array);
  }

  // 메소드 시작
  public static void dualPivotQuickSort(int[] array) {
    dualPivotQuickSort(array, 0, array.length-1);
  }

  // 듀얼 피벗 퀵소트 정렬 시작
  // 피벗 2개를 설정하여 영역을 정렬
  public static void dualPivotQuickSort(int[] array, int low, int high) {

    if(low < high) {

      // high 큰 값, low 작은 값으로 설정
      if(array[low] > array[high]) {
        swap(array, low, high);
      }

      int pivot1 = array[low];
      int pivot2 = array[high];
      int lt = low + 1; // 피벗1보다 작은 요소들의 경계
      int gt = high - 1; // 피벗2보다 큰 요소들의 경계
      int i = low + 1; // 현재 검사 중인 요소

      // p1 시작점, p2 끝점
      // p1과 p2 사이를 탐색하면서 p1보다 작으면 왼쪽으로 보내고 p2보다 크면 오른쪽으로 보낸다.
      // 이 과정에서 lt++, gt-- 과정이 이루어진다.
      // 탐색을 마치면 p1, p2를 위치를 재조정한다.
      // 같은 과정을 반복한다.
      while(i <= gt) {
        if(array[i] < pivot1) {
          swap(array, i++, lt++);
        }
        else if(array[i] > pivot2) {
          swap(array, i, gt--);
        }
        else {
          i++;
        }
      }

      swap(array, low, --lt);
      swap(array, high, ++gt);

      // 재귀적으로 정렬
      dualPivotQuickSort(array, low, lt-1);
      dualPivotQuickSort(array, lt+1, gt-1);
      dualPivotQuickSort(array, gt+1, high);
    }
  }


  // 위치 교환 메소드
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
