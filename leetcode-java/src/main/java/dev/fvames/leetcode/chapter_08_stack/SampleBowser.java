package dev.fvames.leetcode.chapter_08_stack;

/**
 * TODO 类描述
 *
 * @author
 * @version 2021/5/18 17:28
 */

public class SampleBowser {

    public static void main(String[] args) {
        SampleBowser sampleBowser = new SampleBowser();
        sampleBowser.open("www.baidu.com");
        sampleBowser.open("1");
        sampleBowser.open("2");
        sampleBowser.open("3");
        sampleBowser.open("4");
        sampleBowser.goForward();
        sampleBowser.open("5");
        sampleBowser.goBack();
        sampleBowser.goBack();
        sampleBowser.goForward();
        sampleBowser.goForward();
        sampleBowser.goForward();
        sampleBowser.open("6");
        sampleBowser.goBack();
        sampleBowser.goBack();
        sampleBowser.open("7");

        System.out.println("------------------");
        LinkedListBasedStack.Node node = sampleBowser.backStack.top;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }


    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void open(String url) {
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "open");
    }

    public String goForward() {
        if (this.canForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "forward");
            return forwardUrl;
        }
        return null;
    }

    public String goBack() {
        if (this.canBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "back");
            return backUrl;
        }
        return null;
    }

    private void showUrl(String backUrl, String option) {
        this.currentPage = backUrl;
        System.out.println(option + " page = " + backUrl);
    }

    public boolean canBack() {
        return this.backStack.size > 0;
    }

    public boolean canForward() {
        return this.forwardStack.size > 0;
    }

    class LinkedListBasedStack {
        int size;
        Node top;

        public void push(String data) {
            Node node = create(data, top);
            this.top = node;
            size++;
        }

        public String pop() {

            Node popNode = this.top;
            if (null == popNode) {
                System.out.println("Stack is Empty");
                return null;
            }
            this.top = popNode.next;
            if (this.size > 0) {
                this.size--;
            }
            return popNode.data;
        }

        public Node create(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            this.size = 0;
        }

        class Node {
            String data;
            Node next;

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
    }

}
