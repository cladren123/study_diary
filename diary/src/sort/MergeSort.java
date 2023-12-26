package sort;


/*
병합 정렬

참고 영상 : https://www.youtube.com/watch?v=QAyl79dCO_k
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,4,8,7};
    printArray(array);
    mergeSort(array);
    printArray(array);
  }

  // 병합 정렬 시작
  public static void mergeSort(int[] array) {
    int[] temp = new int[array.length];
    mergeSort(array, temp, 0, array.length - 1);
  }

  // 병합 정렬 재귀
  public static void mergeSort(int[] array, int[] temp, int start, int end) {
    if(start < end) {
      // 배열을 반으로 나눔
      int mid = (start + end) / 2;

      // 재귀를 통해 정렬
      mergeSort(array, temp, start, mid);
      mergeSort(array, temp, mid+1, end);

      // 정렬된 왼쪽과 오른쪽을 합치는 함수
      merge(array, temp, start, mid, end);
    }
  }

  // 정렬된 왼쪽과 오른쪽을 합치는 함수
  public static void merge(int[] array, int[] temp, int start, int mid, int end) {
    // 임시 저장소에 왼쪽과 오른쪽을 저장
    for(int i = start; i <= end; i++) {
      temp[i] = array[i];
    }

    int part1 = start; // 왼쪽의 시작지점
    int part2 = mid + 1; // 오른쪽의 시작지점
    int index = start; // 결과 배열에 저장될 인덱스

    // 왼쪽과 오른쪽을 비교해서 작은 것부터 결과 인덱스에 저장
    while(part1 <= mid && part2 <= end) {
      // 왼쪽이 작을 경우
      if(temp[part1] <= temp[part2]) {
        array[index] = temp[part1];
        part1++;
      }
      // 오른쪽이 작을 경우
      else {
        array[index] = temp[part2];
        part2++;
      }
      // 왼쪽, 오른쪽 상관없이 결과 index는 +1이 된다.
      index++;
    }

    // 왼쪽에 남은 부분을 저장한다. (오른쪽이 남았을 경우는 이미 배열 뒤쪽에 배치되어 있다.)
    for(int i = 0; i <= mid-part1; i++) {
      array[index + i] = temp[part1 + i];
    }
  }

  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
