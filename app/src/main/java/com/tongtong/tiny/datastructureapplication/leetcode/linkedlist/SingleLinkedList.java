package com.tongtong.tiny.datastructureapplication.leetcode.linkedlist;

/**
 * @Description: 单链表，提供简单的增删改查方法，不考虑并发情况。
 * 参考LinkedList
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/26 2:38 PM
 * @Version TODO
 */
public class SingleLinkedList {

    private int size = 0;
    private Node first = null;

    /**
     * 增删改查方法
     * add(index, E)        index >= 0 && index <= size
     * remove(index)        index >= 0 && index < size
     * set(index, E)        index >= 0 && index < size
     * get(index)           index >= 0 && index < size
     */

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            sll.add(i, i);
        }
//        sll.add(0, 100);
//        sll.addFirst(111);
//        sll.set(9, 1111);
//        sll.remove(0);
        System.out.println(sll.toString());
        sll.reverseList();
//        System.out.println(sll.getFirst());
//        System.out.println(sll.getLast());
//        System.out.println(sll.get(0));
//        System.out.println(sll.get(sll.getSize()-1));

//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add("111");
//        linkedList.add("222");
//        linkedList.add("333");
//        linkedList.remove(0);
//        linkedList.addLast("sss");
//        System.out.println(linkedList.toString());
    }

    /**
     * 在角标为index的位置插入数据
     *
     * @param index
     * @param value
     * @return
     */
    public boolean add(int index, int value) {
        checkPositionIndex(index);

        if (index == 0) {
            if (first == null) {
                first = new Node(value, null);
            } else {
                Node next = get(0);
                Node node = new Node(value, next);
                first = node;
            }
        } else {
            Node prev = get(index - 1);
            Node node = new Node(value, prev.next);
            prev.next = node;
        }
        size++;
        return true;
    }

    public boolean add(int value) {
        return addLast(value);
    }

    public boolean addFirst(int value) {
        return add(0, value);
    }

    public boolean addLast(int value) {
        return add(getSize(), value);
    }

    public boolean remove(int index) {
        checkElementIndex(index);

        // size > 0
        if (getSize() == 1) {//size == 1
            first = null;
        } else {// size > 1
            if (index == 0) {// 删除第一个数据
                first = first.next;
            } else if (getSize() - 1 == index) {// 删除最后一个数据
                Node prev = get(index - 1);
                prev.next = null;
            } else {// 删除中间的数据
                get(index - 1).next = get(index).next;
            }
        }
        size--;
        return true;
    }

    public boolean set(int index, int value) {
        checkElementIndex(index);
        Node node = get(index);
        node.setItem(value);
        return true;
    }

    /**
     * 获取角标上的数据。
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        checkElementIndex(index);

        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        if (getSize() == 0) {
            return first;
        }
        return get(getSize() - 1);
    }


    /**
     * 返回当前容器大小。
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 反转链表
     *
     * @return
     */
    public Node reverseList() {
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        logFromHead("reverseList", prev);
        return prev;
    }

    public void logFromHead(Node head) {
        logFromHead(null, head);
    }

    public void logFromHead(String tag, Node head) {
        StringBuilder sb = new StringBuilder();
        if (tag != null && tag.length() > 0) {
            sb.append(tag + ":");
        }
        sb.append('[');
        if (head != null) {
            Node curr = head;
            while (curr != null) {
                sb.append(String.valueOf(curr));
                if (curr.next != null) {
                    sb.append(",").append(" ");
                }
                curr = curr.next;
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (first != null) {
            Node curr = first;
            while (curr != null) {
                sb.append(String.valueOf(curr));
                if (curr.next != null) {
                    sb.append(",").append(" ");
                }
                curr = curr.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node {
        private int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

        public void setItem(int item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return String.valueOf(this.item);
        }
    }

}
