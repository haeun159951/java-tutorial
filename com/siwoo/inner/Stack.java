package com.siwoo.inner;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 스택
 *  -  A pushdown stack is a collection that is based on the last-in-first-out (LIFO) policy.
 *  When you click a hyperlink, your browser displays the new page (and pushes onto a stack).
 *  You can keep clicking on hyperlinks to visit new pages, but you can always revisit the previous page by clicking the back button (popping it from the stack).
 *
 */
public interface Stack extends Iterable<String> {

    /**
     * remove the most recently added item.
     *
     * @return
     */
    String pop();

    /**
     * add an item to {@link Stack}
     *
     * @param e
     */
    void push(String e);

    /**
     * is the stack empty?
     *
     * @return
     */
    boolean isEmpty();

    /**
     * number of items in the stack
     *
     * @return
     */
    int size();

}

/**
 * A bag is a collection where removing items is not supported—its purpose is to provide clients with the ability to collect items
 * and then to iterate through the collected items.
 *
 */
interface Bag extends Iterable<String> {

    /**
     * add an item to {@link Bag}
     *
     * @param e
     */
    void add(String e);

    /**
     * is the bag empty?
     *
     * @return
     */
    boolean isEmpty();

    /**
     * number of items in the bag
     *
     * @return
     */
    int size();
}


/**
 * Linked lists.
 *
 * A linked list is a recursive data structure that is either empty (null) or a reference to a node having a generic item and a reference to a linked list.
 * To implement a linked list, we start with a nested class that defines the node abstraction
 *
 * 링크드리스트 구현. (https://coding-factory.tistory.com/552)
 *
 *   링크드리스트의 특징.
 *      1. 내부 클래스 노드로 이루어져 있다.
 *      2. 노드는 데이터와 다음 노드에 대한 참조를 가지고 있다.
 *      3. 링크드리스트에 데이터를 추가할 때, 앞뒤만 변경한다.
 *          (Doubly linked list. 우리는 앞에서만 추가할 수 있는 Singly Linked List 을 구현한다.)
 *
 *  노드 클래스 (내부 클래스)
 *      1. 데이터를 가진다.
 *      2. 다음 노드에 대한 참조를 가진다.
 *
 *  요구사항.
 *      1. 내부 스태 "노드 클래스" 를 정의한다.
 *      2. 클라이언트는 내부 클래스인 "노드 클래스" 의 존재를 몰라야 한다. (캡슐화)
 *      3. 링크드리스트를 개발한 후 Stack 인터페이스, Bag 인터페이를 구현 한다.
 *      4. 요소를 꺼낼 시 (poll), 링크드리스트가 비어있다면 예외를 던진다.
 *      5. 내부 "Iterator" 클래스를 정의한 후, iterator 메서드에서 생성해 리턴한다.
 *
 */
class LinkedList implements Iterable<String>, Bag, Stack{

    private Node head;
    private int cnt;

    public String poll() {
        //끄내다
        if(head == null){
            throw new NoSuchElementException();
        }
        String temp = head.data;
        head = head.next;
        cnt--;
        return temp;
    }

    @Override
    public String pop() {
        return poll();
    }

    public void push(String e) {
        // head
        Node node = new Node(e);
        node.next = head;
        head = node;
        cnt++;
    }


    @Override
    public void add(String e) {
        push(e);
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public int size() {
        return cnt;
    }

    public Iterator<String> iterator() {//익명클래스  - 메서드면 메서드 대가리 먼저 보기 , 파라미터, 리턴타입 메서드 이름을 보면서 확인하기

        Iterator<String> iterator = new Iterator<String>(){

            private Node currentNode = head;

            public String next(){
                String data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }

            public boolean hasNext(){
                return (currentNode !=null);
            }
        };

        return iterator;
    }



    class Node{
        private String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data){
            this.data = data;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push("1");
        list.push("2");
        list.push("3");
//
//        System.out.println("list1: " + list.poll());
//        System.out.println("list2: " + list.poll());
//        System.out.println("list3: " + list.poll());

        for(String data:list) {
            System.out.println(data);
        }

        Bag bag = new LinkedList();
        bag.add("7");
        bag.add("8");
        bag.add("9");
        System.out.println("empty? " + bag.isEmpty());
        System.out.println("size? "+bag.size());


        for (String data:bag){
            System.out.println(data);
        }

        Stack stack = new LinkedList();
        stack.push("5");
        stack.push("6");
        stack.push("7");
        System.out.println("empty? " + stack.isEmpty());
        System.out.println("size? "+stack.size());

        for (String data:stack){
            System.out.println(data);
        }

    }
}
