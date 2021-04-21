package dev.fvames.leetcode.chapter_07_linkedlist;

/**
 * 查找元素在数组中的位置
 *
 * @author
 * @version 2021/4/21 10:06
 */

public class ArrayFindByValueAlgo {

    public static void main(String[] args) {
        int n = 10;
        char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        char key = '4';
        int i1 = find1(a, n, key);
        System.out.println("i1 = " + i1);
        int i2 = find2(a, n, key);
        System.out.println("i2 = " + i2);
        int i3 = find3(a, n, key);
        System.out.println("i3 = " + i3);
    }

    /**
     * 查找 key 在数组 a 中的位置
     *
     * @param a 数组
     * @param n 数组长度
     * @param key 待查找数据
     */
    static int find1(char[] a, int n, char key) {
        if (null == a || n <= 0) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }

        return -1;
    }

    static int find2(char[] a, int n, char key) {
        if (null == a || n <= 0) {
            return -1;
        }

        int j = 0;
        while (j < n) {
            if (a[j] == key) {
                return j;
            }
            j++;
        }

        return -1;
    }

    static int find3(char[] a, int n, char key) {
        if (null == a || n <= 0) {
            return -1;
        }

        //
        if (a[n - 1] == key) {
            return n - 1;
        }

        char tmp = a[n - 1];
        a[n - 1] = key;

        int i = 0;
        while (a[i] != key) {
            i++;
        }

        a[n - 1] = tmp;
        return i == (n - 1) ? -1 : i;
    }
}
