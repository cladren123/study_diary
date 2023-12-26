package sort;

/*
힙 정렬
이진 힙 구조를 사용

배열을 최대 힙으로 변환한다. (부모 노드의 값이 자식 노드들의 값보다 항상 크다.)
힙의 루트(가장 큰 값)을 배열의 마지막 요소와 교환하고 힙의 크기를 하나 줄인다.
이 과정을 힙이 비워질 때까지 반복한다.

자기 자신의 배열에서 계속 힙 구조를 만들기 때문에 추가적인 메모리는 들어가지 않는다.
 */
public class HeapSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,9,4,8,7};
    printArray(array);
    heapSort(array);
    printArray(array);
  }

  public static void heapSort(int[] array) {
    int n = array.length;

    // 최대 힙 구성
    // 완전 이진 트리에서 배열의 절반 이후의 요소들은 모두 리프 노드 (절반 이전은 모두 부모 노드)
    // n/2-1 부터 시작하여 루트 노드까지 거꾸로 이동하여 부모 노드를 입력값으로 넣어 자식 노드와 비교
    // 자식 노드가 더 크다면 부모 노드와 교환한다. 이 과정을 반복하여 root 노드에 최대값이 오게 된다.
    for(int i = n/2-1; i>= 0; i--) {
      heapify(array, n ,i);
    }

    // 힙 정렬
    for(int i = n -1 ; i > 0; i--) {
      swap(array, 0, i);
      
      // 감소된 힙에 대해 힙 조정 (i는 n-1, n-2 이런 식으로 크기가 줄어듬)
      heapify(array, i , 0);
    }
  }

  // heap 조정 함수 (root 노드(0번째 인덱스)에 최댓값을 배치한다.)
  // 부모와 자식을 비교하여 자식이 높은 경우 부모와 자리를 바꾼다. 즉 큰 값을 부모한테 올린다.
  public static void heapify(int array[], int heapSize, int rootIndex) {

    int largest = rootIndex;
    int leftChildIndex  = 2 * rootIndex + 1;
    int rightChildIndex = 2 * rootIndex + 2;

    // 왼쪽 자식이 더 큰 경우
    if(leftChildIndex < heapSize && array[leftChildIndex] > array[largest]) {
      largest = leftChildIndex;
    }

    // 오른쪽 자식이 더 큰 경우
    if(rightChildIndex < heapSize && array[rightChildIndex] > array[largest]) {
      largest = rightChildIndex;
    }

    // 최대값이 루트가 아닌 경우
    if (largest != rootIndex) {
      swap(array, largest, rootIndex);

      heapify(array, heapSize, largest);
    }
  }

  public static void swap(int[] array, int largest, int rootIndex) {
    int temp = array[largest];
    array[largest] = array[rootIndex];
    array[rootIndex] = temp;
  }



  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
