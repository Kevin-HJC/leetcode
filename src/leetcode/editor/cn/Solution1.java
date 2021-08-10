package leetcode.editor.cn;

import java.util.*;

/**
 * @Description: TODO
 * 例子1
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 例子2
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 例子3
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author Huangjingcheng
 * @date 2021/8/9 16:12
 */
public class Solution1 {
    public static void main(String[] args) {
        // 自己的想法
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        One one = new One();
        int[] result = one.dealWith(nums1,nums2);
        System.out.println(Arrays.toString(result));
        // 别人的想法


    }

    static class One{

        /**
         * 别人的想法
         * 作者：guanpengchn
         * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/
         *      hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while(l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;

                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);

                cur = cur.next;
                if(l1 != null)
                    l1 = l1.next;
                if(l2 != null)
                    l2 = l2.next;
            }
            if(carry == 1) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }

        /**
         * 自己的想法
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] dealWith(int[] nums1, int[] nums2){
            //把两个数组合并成一个
            int[] nums = Arrays.copyOf(nums1,nums1.length+nums2.length);
            System.arraycopy(nums2,0,nums,nums1.length,nums2.length);
            int[] result = new int[nums1.length];
            for (int i = 0;i < nums.length;i++){
                if (i < nums1.length){
                    result[i] = nums[i] + nums[nums.length + i-3];
                }
            }
            return result;
        }

        /**
         * 把两个数组合并成一个  泛型
         * @param first
         * @param second
         * @param <T>
         * @return
         */
        public static <T> T[] concat(T[] first, T[] second) {
            T[] result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);
            return result;
        }

    }

    /**
     * 自定义ListNode链表类
     */
    static class ListNode{
        // 链表中的某个值
        int val;
        // 下一个链表对象
        ListNode next;
        // 赋值链表的值
        ListNode(int x){
            val = x;
        }
    }
}
