package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 * @author Huangjingcheng
 * @date 2021/8/10 10:24
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        Three three = new Three();
        int length = three.lengthOfLongestSubstringByKr(s);
        boolean flag = three.isUniqueChars(s);
        System.out.println(length);
    }

    static class Three{
        /**
         * 自己的想法
         * 最长的是字符串本身 一次减少 1 直到找到最长子序列
         * @param s
         * @return
         */
        public int lengthOfLongestSubstringByMyself(String s){
            // String 转 数组
            char[] chars = s.toCharArray();
            int index = 0;
            for (int i = 1;i < chars.length-1;i++){
                for (int j = 0;j < i;j++){
                    isUniqueChars(s.substring(j,chars.length-j));
                }
            }
//            for (int)
            return index+1;
        }

        /**
         * 官方解答
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s){
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<>();
            int n = s.length();
            // 右指针，初始值为-1，相当于我们在字符串的左边界的左边，还没有开始移动
            int rk = -1;
            int ans = 0;
            for (int i = 0;i < n;i++){
                if (i != 0){
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i-1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                    // 不断的移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符字串
                ans = Math.max(ans,rk - i + 1);
            }
            return ans;
        }

        /**
         * kai-rou的解决方式
         * map<k,v>，其中key为字符，value为字符串位置
         * @param s
         * @return
         */
        public int lengthOfLongestSubstringByKr(String s){
            int length = s.length();
            int max = 0;
            Map<Character,Integer> map = new HashMap<>();
            for (int start = 0,end = 0;end < length;end++ ){
                char element = s.charAt(end);
                if (map.containsKey(element)){
                    // map.get()的地方进行 +1 的操作
                    start = Math.max(map.get(element) + 1,start);
                }
                max = Math.max(max,end-start + 1);
                map.put(element,end);
            }
            return max;
        }
        /**
         * 判断一个字符串中是否有重复字符
         * true:有重复
         * false:无重复
         */
        public boolean isUniqueChars(String s){
            if (s == null || s.isEmpty()){
                return false;
            }
            // String转数组
            char[] chars = s.toCharArray();
            for (char c : chars){
                if (s.indexOf(c) != s.lastIndexOf(c)){
                    return true;
                }
            }
            return false;
        }
    }
}
