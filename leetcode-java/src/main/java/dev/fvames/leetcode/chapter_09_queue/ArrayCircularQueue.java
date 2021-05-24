package dev.fvames.leetcode.chapter_09_queue;

/**
 * 基于数组的循环队列
 *
 * (tail + 1) % n == head
 *
 * @author
 * @version 2021/5/24 16:51
 */

public class ArrayCircularQueue {

    private String[] items;
    private int capacity;

    private int head;
    private int tail;

    public ArrayCircularQueue(String[] items, int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String data) {
        if ((tail + 1) % capacity == head) return false;
        items[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String result = items[head];
        head = (head + 1) % capacity;
        return result;
    }

}
