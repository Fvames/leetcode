package dev.fvames.leetcode.chapter_09_queue;

/**
 * 基于数组实现的队列
 *
 * @author
 * @version 2021/5/24 16:25
 */

public class ArrayQueue {

    private String[] items;
    private int capacity;

    private int head;
    private int tail;

    public ArrayQueue(String[] items, int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String data) {
        if (tail == capacity) return false;
        items[tail] = data;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String result = items[head];
        head++;
        return result;
    }
}
