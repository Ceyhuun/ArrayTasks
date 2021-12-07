import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
         /*
         Given the array numbers, for each numbers[i] find out how many numbers in the array are smaller than it.
         That is, for each numbers[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
         Return the answer in an array.

         Constraints:
         2 <= nums.length <= 500
         0 <= nums[i] <= 100
         Input =[37,64,63,2,41,78,51,36,2,20,25,41,72,100, 17,43,54,27,34,86,12,48,70,44,87,68,62,98,68,30,8,92,5,10]
         */


    public static int[] task1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ctr = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ctr++;
                }
            }
            result[i] = ctr;
        }
        return result;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    Given an integer k and an integer start.
    Define an array numbers where numbers[i] = start + 2*i (0-indexed) and k == nums.length.
    Return the bitwise XOR of all elements of numbers.
    input = 751
    start =24
    */
    public static int task2(int n, int start) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = start + 2 * i;
        }
        int result = start;
        for (int i = 0; i < n - 1; i++) {
            result = result ^ array[i + 1];
        }
        return result;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet
    input = 754508321
    .*/
    public static String task3(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int i = (columnNumber - 1) % 26;
            char ch = (char) ('A' + (char) (i));
            sb.insert(0, ch);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.toString();
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    Given an integer array numbers, return the third distinct maximum number in this array.
    If the third maximum does not exist, return the maximum number.
    input = [37,64,63,2,41,78,51,36,2,20,25,41,72,100, 17,43,54,27,34,86,12,48,70,44,87,68,62,98,68,30,8,92,5,10]
    */
    public static int task4(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums) {
            if (!list.contains(n)) {
                list.add(n);
            }
        }
        if (list.size() < 3) {
            int max = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                }
            }
            return max;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }
        return max3;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    Given a binary array nums, you should delete one element from it.
    Return the size of the longest non-empty subarray containing only 1's in the resulting array.
    Return 0 if there is no such subarray.
    input = [1,1,1,1,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,1,1,1,0,1,1,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,0]
    */
    public static int task5(int[] nums) {
        int[] numbers = new int[nums.length];
        int index = 0;
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                a++;
            else {
                numbers[index] = a;
                index++;
                a = 0;
            }
        }
        if (a != 0) {
            numbers[index] = a;
            index++;
        }
        int m = numbers[0] - 1;
        for (int i = 0; i < index - 1; i++)
            m = Math.max(m, numbers[i] + numbers[i + 1]);
        return m;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    You are given an integer num. You can swap two digits at most once to get the maximum valued number.
    Return the maximum valued number you can get.
    input = 20398736
    */
    public static int task6(int num) {
        String s = Integer.toString(num);
        boolean found = false;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) < s.charAt(j)) {
                    first = i;
                    if (second == Integer.MIN_VALUE) {
                        second = j;
                    } else if (s.charAt(second) < s.charAt(j)) {
                        second = j;
                    } else if (s.charAt(second) == s.charAt(j)) {
                        second = j;
                    }
                    found = true;
                }
            }
            if (found)
                break;
        }
        if (found) {
            StringBuilder sb = new StringBuilder(s);
            char ch = s.charAt(first);
            sb.setCharAt(first, s.charAt(second));
            sb.setCharAt(second, ch);
            return Integer.parseInt(sb.toString());
        } else {
            return num;
        }
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    input = 43
    */
    public static int task7(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; ++i) {
            int total = first + second;
            first = second;
            second = total;
        }
        return second;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------
    Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary
    representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
    Return the sorted array.
    input = [1,564,32,13,14,987,26,73,40,756,12,32,45,873,1010, 73,1024,765,23,0,87,100,125,144,999,1065,36,63,21]
    */
    public static int[] task8(int[] arr) {
        Arrays.sort(arr);
        int[][] indexing = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            int[] index = new int[2];
            index[0] = count(arr[i]);
            index[1] = arr[i];
            indexing[i] = index;
        }
        Arrays.sort(indexing, Comparator.comparingInt(a -> a[0]));
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = indexing[i][1];
        }
        return a;
    }
    public static int count(int n) {
        int numberOfBit = 0;
        while (n > 0) {
            numberOfBit += n & 1;
            n >>= 1;
        }
        return numberOfBit;
    }
}
