package dev.fvames.leetcode.chapter_06_linkedlist;

import dev.fvames.leetcode.Node;
import dev.fvames.leetcode.NodeUtils;

/**
 * 回文字符串验证
 *
 * @author
 * @version 2021/5/13 13:03
 */

public class SinglyLinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        NodeUtils nodeUtils = new NodeUtils();

        //String[] arr = {"1", "2", "3", "3", "2", "1"};
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        //String[] arr = {"1", "2", "3", "4", "2", "1"};
        list.head = nodeUtils.insert(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(",");
        }

        boolean isPalindrome = list.palindrome();
        System.out.printf("数组 %s 是否是回文字符：%s", sb.toString(), isPalindrome);
    }

    /** 判断是否是回文 */
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            // 找到中点
            Node slowNode = head;
            Node fastNode = head;
            while (fastNode.next != null && fastNode.next.next != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
            System.out.println("中间节点： " + slowNode.data);

            // 翻转
            Node leftLink = null;
            Node rightLink = null;
            // 节点数目为奇数
            if (fastNode.next == null) {

                rightLink = slowNode.next;
                leftLink = inverseLinkList(slowNode).next;
            } else {

                rightLink = slowNode.next;
                leftLink = inverseLinkList(slowNode);
            }

            return tFResult(leftLink, rightLink);
        }
    }

    /** 反转 */
    private Node inverseLinkList(Node slowNode) {
        Node pre = null;
        Node node = head;
        Node next = null;

        while (node != slowNode) {
            next = node.next;

            node.next = pre;
            pre = node;
            node = next;
        }

        node.next = pre;
        return node;
    }

    /** 判断是否是回文 */
    public boolean tFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        while (l != null && r != null) {
            if (l.data != r.data) {
                return false;
            }

            l = l.next;
            r = r.next;
        }
        return true;
    }

}
