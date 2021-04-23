package dev.fvames.leetcode.chapter_06_linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现 LRU 缓存
 * 1.空间复杂度为 O(n)
 * 2.时间复杂度为 O(n)
 * 3.不支持 null 的缓存
 *
 * @author
 * @version 2021/4/21 14:29
 */

public class LRUBasedArray<T> {

    private static final int DEFAUTL_CAPACITY = (1 << 3);
    private T[] value;
    private int count;
    private int capaCity;
    private Map<T, Integer> holder;

    public static void main(String[] args) {
        //testWithException();
        //testDefaultConstructor();
        testSpecifiedConstructor(3);
    }

    private static void testWithException() {
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(null);
    }

    public static void testDefaultConstructor() {
        System.out.println("======无参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        System.out.println(lru);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        System.out.println(lru);
    }

    public static void testSpecifiedConstructor(int capacity) {
        System.out.println("======有参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(3);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(7);
        System.out.println(lru);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
    }

    public LRUBasedArray() {
        this.capaCity = DEFAUTL_CAPACITY;
        this.value = (T[]) new Object[DEFAUTL_CAPACITY];
        this.holder = new HashMap<>();
    }

    public LRUBasedArray(int capacity) {
        this.capaCity = capacity;
        this.value = (T[]) new Object[capacity];
        this.holder = new HashMap<>();
    }

    public void offer(T object) {
        if (null == object) {
            throw new IllegalArgumentException("不支持 null");
        }

        Integer index = holder.get(object);
        if (null == index) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    private void removeAndCache(T object) {
        T t = value[--count];
        holder.remove(t);

        cache(object, count);
    }

    private void update(Integer index) {
        T target = value[index];
        // 当前数据提至首位
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    private void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 数据右移一位
     *
     * @param end 当前最大位下表
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    private boolean isFull() {
        return count == capaCity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

}
