package com.s77;

/**
 * @author s77
 * @date 2021-09-02 21:59
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode t = this;
        System.out.print("[");
        System.out.print(t.val + ", ");
        while (t.next != null) {
            t = t.next;
            System.out.print(t.val + ", ");
        }
        System.out.print("]");
    }

}
