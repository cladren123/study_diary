package sort;


/*
계수 정렬  Counting Sort
시간 복잡도 : O(n + k)

정수 배열에서만 사용 가능
정수의 개수를 센 다음 정렬
 */
public class CountingSort {

  public static void main(String[] args) {
    int[] array = {4, 2, 2, 8, 3, 3, 1};
    printArray(array);
    countingSort(array);
    printArray(array);
  }

  public static void countingSort(int[] array) {
    int n = array.length;

    // 최댓값 찾기
    int max = array[0];
    for(int i = 1; i < n; i++) {
      max = Math.max(max, array[i]);
    }

    // 계수 배열 초기화
    int[] count = new int[max+1];

    // 각 숫자 출현 횟수 세기
    for(int i = 0; i < n; i++) {
      count[array[i]]++;
    }

    // 계수 배열의 누적합 계산 - 시작 인덱스 표시, 안정적인 정렬(같은 요소가 있을 때, 순서 유지)
    for(int i = 1; i <= max; i++) {
      count[i] += count[i -1];
    }

    // 결과 배열 초기화
    int[] output = new int[n];

    // 원본 배열을 역순으로 순회하며 결과 배열에 정렬된 데이터 배치
    for(int i = n - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--; // 요소의 시작 인덱스 조정
    }
    // count = {0, 1, 3, 5, 6, 6, 6, 7} 누적합의 요소는 시작 인덱스, 인덱스는 뒤에서부터 채워진다.
    // array = {4, 2, 2, 8, 3, 3, 1} 이면 1부터 탐색을 시작한다.
    // output[count[array[i]] - 1] 에서 i가 n-1이면 output[0] = 1 이 된다.
    // output = {1, 0, 0, 0, 0, 0, 0}
    // count[1]-- 이 되어 0이 된다.
    // count = {0, 0, 3, 5, 6, 6, 6, 7}

    // i = n-2이면 array[5] = 3이 된다.
    // output[count[3] - 1] = 3, count[3] - 1 은 5 - 1이므로 4이다. output[4] = 3이 된다.
    // output = {1, 0, 0, 0, 3, 0, 0}
    // count[3]-- 이 되어 4가 된다
    // count = {0, 0, 3, 4, 6, 6, 6, 7}

    // i = n-3이면 array[4] = 3이 된다.
    // output[count[3] - 1] = 3, count[3] - 1은 4 -1 이므로 3이다. output[3] = 3이 된다.
    // output = {1, 0, 0, 3, 3, 0, 0}
    // count[3]-- 이 되어 3이 된다.
    // count = {0, 0, 3, 3, 6, 6, 6, 7}

    // 이런 식으로 인덱스가 줄어들면서 뒤에서부터 정렬이 진행된다.


    // 결과 배열을 원본 배열에 복사
    System.arraycopy(output, 0, array, 0, n);

  }



  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }
}
