package com.s77.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2617 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



/**
 * 思路： 使用栈来判断是否匹配，可以先将括号匹配关系放到map中维护，遇到左括号（containKey）就入栈，遇到右括号就弹出栈顶元素，查看是否匹配，不匹配直接返回false
 * 可以判断一些特殊条件来提前返回, 如：字符串尾元素是左括号就直接返回false
 * */


/**
 * @author s77
 * @date 2021-09-06 20:51:42
 */
public class Q20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q20ValidParentheses().new Solution();
        String s = "([)]";
        System.out.println(solution.isValid(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> parenthesMap = new HashMap<>();
            parenthesMap.put(')', '(');
            parenthesMap.put('}', '{');
            parenthesMap.put(']', '[');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (parenthesMap.get(c) != null && parenthesMap.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

