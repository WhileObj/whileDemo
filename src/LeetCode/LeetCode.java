package LeetCode;

import javax.sound.midi.Soundbank;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class LeetCode {
    public static void main(String[] args) {

        //1.两数之和

//        int[] num={2, 7, 11, 15};
//        int target=9;
//        twoSum(num,target);


        //7.整数反转

//        reverse(214748364);


        //9.回文数
//        isPalindrome(0);

    }


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        /*方法一：穷举----思路简单，速度慢*/
//        for (int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    return new int[] {i,j};
//                }
//            }
//        }
        //****************************************

        /*方法二：利用两次hash表----思路略复杂，速度比穷举快，但耗费更多内存*/
//        Map<Integer,Integer> result=new HashMap<>();
//        //第一次将nums中的数字放入hash表中
//       for(int i=0;i<nums.length;i++){
//           result.put(nums[i],i);
//       }
//       //第二次判断需要的元素是否存在于hash表中
//        for(int i=0;i<nums.length;i++){
//            int temp=target-nums[i];
//            if(result.containsKey(temp)&&result.get(temp)!=i){
//                return new int[] {i,result.get(temp)};
//            }
//        }
        //****************************************

        /*方法三：利用一次hash表----思路略复杂，速度最快*/
        Map<Integer, Integer> result = new HashMap<>();
        //边找边放，找到就返回
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (result.containsKey(temp)) {
                return new int[]{result.get(temp), i};
            }
            result.put(nums[i], i);
        }
        //****************************************
        return null;
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {//循环判断x是否被除尽
            int pop = x % 10;//拿到x的最后一个数字
            x /= 10;//将最后一位数字除去

            /***
             * 判断溢出：
             *              32位整数最大值：-2147483648< x <2147483647
             *              如果result的值已经大于 （2147483647/10）了，那么无论下一次的pop值为多少，都会溢出
             *              如果result的值等于最大值，那么下一次的pop值大于7才会溢出，故有以下判断（最小值同理）
             */
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }//判读最大值是否溢出
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MAX_VALUE && pop < -8)) {
                return 0;
            }//判读最小值是否溢出
            result = result * 10 + pop;//将拿到的最后一位数字加上，每一次给结果乘以10相当于进位
        }
        System.out.println(result);
        return result;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        //方法一：将数字转换为字符串做对比

//                String str1 = x + "";
//                // String str1 = Integer.toString(num);
//                // String str1 = String.valueOf(num);
//
//                StringBuilder str2 = new StringBuilder(str1);
//                str2.reverse();
//                int count = 0;
//
//                for (int i = 0; i < str1.length(); i++) {
//                    if (str1.charAt(i) != str2.charAt(i)) {
//                        break;
//                    } else {
//                        count++;
//                    }
//                }
//                if (count == str1.length()) {
//                    return true;
//                }


        //方法二：将数字直接反转后与原数字对比，若相等则为回文数（负数全部不是回文数）---会遇到整数溢出的问题
//        if(x<0){
//            return false;
//        }
//        int result=0;
//        int temp=x;
//        while (x!=0){//循环判断x是否被除尽
//            int pop=x%10;//拿到x的最后一个数字
//            x/=10;//将最后一位数字除去
//            result=result*10+pop;//将拿到的最后一位数字加上，每一次给结果乘以10相当于进位
//        }
//        System.out.println(temp==result);
//        return x==result;


        //方法三：将数字的一半进行反转，并且于前半段进行对比，若反转后的数字与前半段数组相等则为回文数
        //如1221，将后半段21反转为12，与前半段12对比，相等则为回文数，这样可以解决整数溢出的问题
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int temp = 0;
        while (x > temp) {//当x>temp时，则反转完一半，并且x剩余另外一半
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        System.out.println(x == temp || x == temp / 10);
        return x == temp || x == temp / 10;
    }


}
