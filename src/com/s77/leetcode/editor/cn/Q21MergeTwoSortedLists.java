package com.s77.leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1894 👎 0

import com.s77.ListNode;

/**
 *
 * 思路，由于两个链表都是有序的，我们只需要保证返回的都是头指针即可，l1，l2分别是待排序的链表的头，和已经排好序的链表的尾部（即下一个就是还需要排序的链表）
 * 递归的三部分：
 * 递归出口 ：l1 ,l2 任意一个为空
 * 递归返回的值： 排好序的链表的头
 * 本级递归要做的事： 判断大小，把小的值的下一个和另一链表继续合并
 *
 * 或者用遍历的方式 ， 设置虚拟头节点 和指针 p ，两个节点都不为空 逐个移动遍历，小的就加到虚拟头节点后面, p后移一位， 直到遍历完短的，再把长的直接加到后面，返回head.next即可
 *
 * */



/**
 * @author s77
 * @date 2021-09-06 21:26:25
 */
public class Q21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q21MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = solution.mergeTwoLists(l1, l2);
        result.print();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l2, l1.next);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

