package dev.fvames.leetcode.chapter_09_queue;

import dev.fvames.leetcode.Node;

/**
 * 链表队列
 *
 * @author
 * @version 2021/5/24 16:03
 */

public class QueueBasedOnLinkedList {

    private Node head;
    private Node tail;

    public void enqueue(int data) {
        Node node = new Node(data, null);
        if (null == tail) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public Node dequeue() {
        if (head == null) return null;
        Node result = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return result;
    }

}
