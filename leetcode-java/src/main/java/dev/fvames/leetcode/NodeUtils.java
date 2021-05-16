package dev.fvames.leetcode;

/**
 * TODO 类描述
 *
 * @author
 * @version 2021/5/14 16:29
 */

public class NodeUtils {
    private Node head;

    public Node insert(int[] datas) {
        head = null;
        for (int i : datas) {
            insertTail(i);
        }
        return head;
    }

    public Node insertTail(int data) {
        Node newNode = new Node(data, null);

        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            q.next = newNode;
        }
        return head;
    }
}
