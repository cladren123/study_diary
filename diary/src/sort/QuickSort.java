package sort;

public class QuickSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,4,8,7};
    printArray(array);
    quickSort(array);
    printArray(array);
  }

  // 퀵 정렬 시작
  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  // 재귀 수행(pivot을 중심으로 왼쪽 작은 것, 오른쪽 큰 것으로 한다)
  public static void quickSort(int[] array, int start, int end) {
    int part2 = partition(array, start, end); // 오른쪽의 첫 번째 인덱스를 받아옴

    // 처음 위치가 오른쪽 첫 번째 인덱스 바로 다음 칸이면 왼쪽의 크기가 1이라는 뜻
    // part2 - 1 이 2 이상일 때는 왼쪽의 크기가 2 이상이라는 뜻으로 정렬을 진행한다.
    if(start < part2 - 1) {
      quickSort(array, start, part2 - 1);
    }
    // 오른쪽 부분의 첫 번째 시작점이 end이면 오른쪽 크기가 1이라는 뜻
    // part2 < end 는 오른쪽 크기가 2 이상이란 뜻으로 정렬을 진행한다.
    if(part2 < end) {
      quickSort(array, part2, end);
    }
  }

  // 배열을 나누는 부분
  public static int partition(int[] array, int start, int end) {
    // 여기서 pivot은 중간 지점으로 설정
    int pivot = array[(start + end) / 2];

    // 반복문을 통해 pivot을 중심으로 왼쪽은 작은 값, 오른쪽은 큰 값이 오게 된다.
    while(start <= end) {
      // 왼쪽에서 pivot 보다 큰 값을 찾음
      while(array[start] < pivot) start++;

      // 오른쪽에서 pivot 보다 작은 값을 찾음
      while(array[end] > pivot) end--;

      // 두 개의 인덱스를 교환하고 탐색을 계속한다.
      if(start <= end) {
        swap(array, start, end);
        start++;
        end--;
      }
    }
    // while문을 반복하면 start에는 오른쪽 부분의 첫 번째 인덱스가 저장된다.
    return start;
  }

  // 배열의 2개의 위치의 값을 바꿈
  public static void swap(int[] array, int start, int end) {
    int temp = array[start];
    array[start] = array[end];
    array[end] = temp;
  }

  // 배열 출력
  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
