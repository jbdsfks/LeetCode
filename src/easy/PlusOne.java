package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 66. Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * @Author lzj
 * @Date 2019/5/26 9:46
 */
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
//            List<Integer> list = new ArrayList<>();
//            int sum = 1;
//            for (int i = digits.length - 1;i >= 0; i--){
//                int tempSum = sum + digits[i];
//                list.add(tempSum % 10);
//                sum = tempSum / 10;
//            }
//            if (sum > 0)
//                list.add(sum);
//            int[] res = new int[list.size()];
//            for (int i = 0; i < list.size(); i++)
//                res[i] = list.get(list.size() - i - 1);
//            return res;
            int sum = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int tempSum = sum + digits[i];
                digits[i] = tempSum % 10;
                sum = tempSum / 10;
            }
            if (sum > 0){
                int[] newDigits = new int[digits.length+1];
                newDigits[0] = sum;
                for (int i = 0;i<digits.length;i++)
                    newDigits[i+1] = digits[i];
                return newDigits;
            }else return digits;
        }
    }
}
