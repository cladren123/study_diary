package sort;

public class QuickSort {

  public static void main(String[] args) {
    int[] array = {3,1,5,4,8,7};

    printArray(array);

  }

  public static void printArray(int[] array) {
    for(int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
