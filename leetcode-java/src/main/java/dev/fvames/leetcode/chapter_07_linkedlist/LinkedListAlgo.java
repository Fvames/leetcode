package dev.fvames.leetcode.chapter_07_linkedlist;

import dev.fvames.leetcode.Node;
import dev.fvames.leetcode.NodeUtils;

/**
 * 1、单链表的反转
 * 2、链表中环的检测
 * 3、两个有序链表的合并
 * 4、删除链表的倒数第 k 个节点
 * 5、求链表的中间节点
 *
 * @author
 * @version 2021/5/14 10:22
 */

public class LinkedListAlgo {

    public static void main(String[] args) {
        NodeUtils nodeUtils = new NodeUtils();
        int[] arr = {1, 3, 4, 5, 6, 7, 12};
        Node reverseNode = reverse(nodeUtils.insert(arr));
        System.out.println(reverseNode.toString());

        int[] c0 = {1, 3, 4, 5, 6, 7, 12};
        System.out.println(checkCircle(nodeUtils.insert(c0)));
        Node c1 = new Node(1, null);
        Node c2 = new Node(2, c1);
        Node c3 = new Node(3, c2);
        c1.setNext(c3);
        System.out.println(checkCircle(c1));

        int[] arr1 = {2, 4, 6, 8, 10, 11};
        Node mergeNode = mergeSortedLists(nodeUtils.insert(arr), nodeUtils.insert(arr1));
        System.out.println(mergeNode.toString());
    }

    public static Node reverse(Node list) {
        Node pre = null;
        Node currNode = list;
        while (currNode != null) {
            Node next = currNode.next;

            currNode.next = pre;
            pre = currNode;

            currNode = next;
        }
        return pre;
    }

    public static boolean checkCircle(Node list) {
        if (null == list) {
            return false;
        }
        Node slowNode = list;
        Node fastNode = list.next;
        while (fastNode != null && fastNode.next != null) {
            if (slowNode == fastNode) {
                return true;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }

    public static Node mergeSortedLists(Node la, Node lb) {
        if (null == la) return lb;
        if (null == lb) return la;

        Node l = la;
        Node r = lb;
        // 确认头节点
        Node head;
        if (l.data < r.data) {
            head = l;
            l = l.next;
        } else {
            head = r;
            r = r.next;
        }

        Node temp = head;
        while (l != null && r != null) {
            if (l.data < r.data) {
                temp.next = l;
                l = l.next;
            } else {
                temp.next = r;
                r = r.next;
            }

            temp = temp.next;
        }

        if (l != null) {
            temp.next = l;
        }
        if (r != null) {
            temp.next = r;
        }

        return head;
    }

    /** 加入哨兵节点，简化实现难度 */
    public Node mergeTwoLists(Node la, Node lb) {
        Node node = new Node(0, null);

        Node temp = node;
        while (la != null && lb != null) {
            if (la.data < lb.data) {
                temp.next = la;
                la = la.next;
            } else {
                temp.next = lb;
                lb = lb.next;
            }
            temp = temp.next;
        }
        if (la != null) temp.next = la;
        if (lb != null) temp.next = lb;
        return node.next;
    }

}
