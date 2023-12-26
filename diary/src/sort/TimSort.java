package sort;


/*
팀소트
시간복잡도 : O(n log n)
삽입 정렬과 병합 정렬의 장점을 합친 정렬
배열을 수많은 요소들로 나눈다(32 ~ 64 등등)
이 요소들은 런이라 불리면 각 런에 대해 삽입 정렬을 통해 정렬한다.
정렬된 런들을 합하여 전체 배열의 정렬을 완성한다.

작은 런들에서 효율적인 삽입 정렬의 이점을 보고 큰 배열에서는 효율적인 병합 정렬의 이점을 모두 활용한다.
 */
public class TimSort {


  // 런의 크기 설정
  private static final int RUN = 32;

  public static void main(String[] args) {
    int[] array = {3,1,5,9,4,8,7,10,13,15,17,20,30,25};
    printArray(array);
    long start = System.currentTimeMillis();
    timSort(array);
    long end = System.currentTimeMillis();
    printArray(array);
    System.out.println(start + " " + end);
  }

  public static void timSort(int[] array) {
    int n = array.length;

    // 런 크기에 따라 배열을 여러 부분으로 나누고 각 부분에 대해 삽입 정렬 수행한다.
    for(int i = 0; i < n; i += RUN) {
      insertionSort(array, i, Math.min( (i + RUN - 1), n-1 ));
    }

    // 런들을 병합
    // RUN이 2라면 처음에는 크기가 2인 런들을 병합한다.
    // 그 이후 4, 8, 16인 런들을 병합한다.
    for(int size = RUN; size < n; size = 2 * size) {
      for(int left = 0; left < n; left += 2 * size) {
        int mid = left + size - 1; // 첫 번째 런의 마지막 인덱스
        int right = Math.min( (left + 2 * size - 1), (n-1) ); // 두 번째 런의 마지막 인덱스

        if(mid < right) { // 두런이 겹치지 않을 경우에 병합을 수행
          merge(array, left, mid, right);
        }
      }
    }
  }

  // 삽입 정렬
  public static void insertionSort(int[] array, int left, int right) {
    for(int i = left + 1; i <= right; i++) {

      // 탐색하는 값이 앞의 값보다 작으면 위치를 바꿈
      // 즉, 앞의 값이 작을 때까지 계속 앞으로 보내서 정렬시킴
      int temp = array[i];
      int j = i - 1;
      
      while(j >= left && array[j] > temp) {
        array[j + 1] = array[j];
        j--;
      }
      array[j+1] = temp;
    }
  }

  // 배열의 두 부분을 병합하는 메소드
  public static void merge(int[] array, int l, int m, int r) {
    // 병합할 두 부분 배열의 크기를 찾는다.
    int len1 = m - l + 1;
    int len2 = r - m;

    int[] left = new int[len1];
    int[] right = new int[len2];

    // 데이터를 임시 배열로 복사
    System.arraycopy(array, l, left, 0, len1);
    System.arraycopy(array, m+1, right, 0, len2);

    // 병합 과정
    int i = 0; // left 인덱스
    int j = 0; // right 인덱스
    int k = l; // 병합 될 배열의 인덱스

    while(i < len1 && j < len2) {
      if(left[i] <= right[j]) {
        array[k++] = left[i++];
      }
      else {
        array[k++] = right[j++];
      }
    }

    // 남은 요소 복사
    while(i < len1) {
      array[k++] = left[i++];
    }
    while(j < len2) {
      array[k++] = right[j++];
    }

  }

  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }
}
