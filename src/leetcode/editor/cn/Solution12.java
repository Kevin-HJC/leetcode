package leetcode.editor.cn;

/**
　* @Description: ${todo}
　* @param ${tags}
　* @return ${return_type}
　* @author huangjingcheng
　* @date  22:00
　*/
public class Solution12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
    }

    static class Solution {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuffer roman = new StringBuffer();
            for (int i = 0; i < values.length; ++i) {
                int value = values[i];
                String symbol = symbols[i];
                while (num >= value) {
                    num -= value;
                    roman.append(symbol);
                }
                if (num == 0) {
                    break;
                }
            }
            return roman.toString();
        }
    }

}
