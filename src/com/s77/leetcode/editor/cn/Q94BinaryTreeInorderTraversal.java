package com.s77.leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1085 👎 0

import com.s77.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author s77
 * @date 2021-09-08 21:38:50
 */
public class Q94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q94BinaryTreeInorderTraversal().new Solution();
        TreeNode t2Left = new TreeNode(2);
        TreeNode t2Right = new TreeNode(3);
        TreeNode root = new TreeNode(1, t2Left, t2Right);

        for (Integer integer : solution.inorderTraversal(root)) {
            System.out.print(integer + "->");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            return inoderByIterator(root, new ArrayList<>());
        }


        private List<Integer> inoderByIterator(TreeNode cur, List<Integer> result) {
            Deque<TreeNode> stk = new LinkedList<>();
            while (cur != null || !stk.isEmpty()) {
                while (cur != null) {
                    stk.push(cur);
                    cur = cur.left;
                }
                cur = stk.pop();
                result.add(cur.val);
                cur = cur.right;
            }
            return result;
        }

        private List<Integer> inorder(TreeNode cur, List<Integer> result) {
            if (cur == null) {
                return result;
            }
            inorder(cur.left, result);
            result.add(cur.val);
            inorder(cur.right, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

