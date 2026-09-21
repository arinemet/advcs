public class Sort {

  // randomly shuffles the elements of arr
  public static void scramble(int[] arr) {
    for (int i = arr.length - 1; i > 0; i--) {
      int j = (int) (Math.random() * (i + 1));
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  // searches a sorted (importnat that it is sorted) array for target, returns
  // index or -1 if not found
  public static int binarySearch(int[] arr, int target) {
    int lo = 0;
    int hi = arr.length - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  // sorts arr in ascending order using bubble sort
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }

  // sorts arr in ascending order using merge sort
  public static void mergeSort(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    int mid = arr.length / 2;

    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = arr[i];
    }
    for (int i = mid; i < arr.length; i++) {
      right[i - mid] = arr[i];
    }

    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right);
  }

  // merges two sorted arrays, left and right, back into arr
  private static void merge(int[] arr, int[] left, int[] right) {
    int i = 0; // index into left
    int j = 0; // index into right
    int k = 0; // index into arr

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }

    while (i < left.length) {
      arr[k] = left[i];
      i++;
      k++;
    }

    while (j < right.length) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }
}
