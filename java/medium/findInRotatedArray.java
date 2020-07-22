package medium;

public class findInRotatedArray {
  public static int solution1(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == target) return mid;

      if (arr[mid] < arr[end]) {
        // all element to the right are greater than mid
        if (target > arr[mid]) {
          if (target > arr[end]) {
            end = mid - 1;
          } else {
            start = mid + 1;
          }
        } else {
          // go left since we know all elements to the right are greater
          end = mid - 1;
        }
      } else {
        // all elements to the left are less than mid
        if (target < arr[mid]) {
          if (target <= arr[end]) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        } else {
          // go right, since we know all elements to the left are less
          start = mid + 1;
        }
      }
    }
    return -1;
  }

  public static int solution2(int[] arr, int target) {
    // find offset index ie by how much was the input shifted?
    // we find this by getting the index of min element
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      int mid = start + (end - start)/2;

      if (arr[mid] > arr[end]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    int offset = start;

    start = 0;
    end = arr.length - 1;

    // do normal binary search, taking into consideration, the offset

    while (start <= end) {
      int mid = start + (end - start)/2;

      int actualMid = (mid + offset) % arr.length;

      // use offset to compare values
      if (arr[actualMid] == target) {
        return actualMid;
      }

      if (arr[actualMid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] input = {0, 1, 2, 3, 4, 5, 6, 7};
    int[] input1 = {2, 3, 4, 5, 6, 7, 0, 1};
    int[] input2 = {4, 5, 6, 7, 0, 1, 2, 3};

    System.out.println("*******SOLUTION 1*********");
    System.out.println(findInRotatedArray.solution1(input, 3));
    System.out.println(findInRotatedArray.solution1(input1, 0));
    System.out.println(findInRotatedArray.solution1(input2, 5));

    System.out.println("*******SOLUTION 2*********");
    System.out.println(findInRotatedArray.solution2(input, 3));
    System.out.println(findInRotatedArray.solution2(input1, 0));
    System.out.println(findInRotatedArray.solution2(input2, 5));
  }
}