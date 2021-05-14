package dev.fvames.leetcode;

/**
 * TODO 类描述
 *
 * @author
 * @version 2021/5/14 13:55
 */

public class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("," + data);
        Node node = next;
        while (node != null) {
            sb.append(",").append(node.data);
            node = node.next;
        }

        return sb.toString().replaceFirst(",", "");
    }
}
