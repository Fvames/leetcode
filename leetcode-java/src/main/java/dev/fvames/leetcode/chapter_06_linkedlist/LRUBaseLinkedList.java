package dev.fvames.leetcode.chapter_06_linkedlist;

import java.util.Scanner;

/**
 * 基于单链表的 LRU 算法
 *
 * @param <T>
 */
public class LRUBaseLinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;

    private int capaCity;
    private int length;
    private SNode<T> headNode;

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (null != sc) {
                list.add(sc.nextInt());
            }
            list.printAll();
        }
    }

    public LRUBaseLinkedList() {
        this.capaCity = DEFAULT_CAPACITY;
        this.headNode = new SNode<>();
    }

    public LRUBaseLinkedList(int capaCity) {
        this.capaCity = capaCity;
        this.headNode = new SNode<>();
    }

    public void add(T data) {
        if (null == data) return;
        SNode preNode = findPreNode(data);

        if (null != preNode) {
            // 已存在
            // 删除 data
            deleteElemOptim(preNode);
            // 保存 data 到首节点
            insertElemAtBegin(data);
        } else {
            // 不存在
            if (length >= capaCity) {
                // delete last node
                deleteElemAtEnd();
            }
            // add data to first node
            insertElemAtBegin(data);
        }
    }

    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        if (headNode.getNext() == null) return;

        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }
        ptr.setNext(null);
        length--;
    }

    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    private class SNode<T> {
        private T element;
        private SNode next;

        public SNode() {
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}
