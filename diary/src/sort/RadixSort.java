package sort;


import java.util.Arrays;

/*
기수 정렬  Radix Sort

시간복잡도 : O(nk) n : 배열의 길이 k 숫자의 최대 자릿수
자릿수를 기준으로 정렬

숫자 범위가 넓거나 정렬해야 할 문자열이 길 때 효과적이다.
그러나, 추가적인 메모리를 요구하며 자릿수가 많은 데이터에 대해서는 속도가 느려질 수 있다.
 */
public class RadixSort {

  public static void main(String[] args) {
    int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
    printArray(array);
    radixSort(array);
    printArray(array);
  }

  // 기수 정렬 시작
  public static void radixSort(int[] array) {
    int n = array.length;

    // 가장 큰 숫자를 찾아 자릿수를 결정한다.
    int max = getMax(array, n);

    // 모든 자릿수에 대해 계수 정렬을 수행한다.
    for(int exp = 1; max / exp > 0; exp *= 10) {
      countSort(array, n, exp);
    }
  }

  // 가장 큰 숫자를 찾는 메소드
  static int getMax(int[] array, int n) {
    int max = array[0];
    for(int number : array) {
      max = Math.max(max, number);
    }
    return max;
  }


  // 각 자릿수마다정렬
  public static void countSort(int[] array, int n, int exp) {

    // 결과값을 저장할 배열
    int[] output = new int[n];

    // 각 자릿수에 따른 숫자의 출현 횟수
    int[] count = new int[10];
    for(int i = 0; i < n; i++) {
      count[(array[i] / exp) % 10]++;
    }

    // 누적합 계싼
    for(int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // 결과 배열 생성
    for(int i = n - 1; i >= 0; i--) {
      output[count[(array[i] / exp) % 10] - 1] = array[i];
      count[(array[i] / exp) % 10]--;
    }

    // 원래 배열 결과 복사
    for(int i = 0; i < n; i++) {
      array[i] = output[i];
    }
  }


  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
