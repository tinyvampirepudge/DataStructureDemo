package com.tongtong.tiny.datastructureapplication.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 单链表，提供简单的增删改查方法，不考虑并发情况。
 * 参考LinkedList
 * @Author wangjianzhou@qding.me
 * @Date 2018/10/26 2:38 PM
 * @Version TODO
 */
public class SingleLinkedList {

    private int size = 0;
    private SingleNode first = null;

    /**
     * 增删改查方法
     * add(index, E)        index >= 0 && index <= size
     * remove(index)        index >= 0 && index < size
     * set(index, E)        index >= 0 && index < size
     * get(index)           index >= 0 && index < size
     */

    public static void main(String[] args) {
//        SingleLinkedList sll = new SingleLinkedList();
//        for (int i = 0; i < 10; i++) {
//            sll.add(i, i);
//        }
//        sll.add(0, 100);
//        sll.addFirst(111);
//        sll.set(9, 1111);
//        sll.remove(0);
//        System.out.println(sll.toString());
//        sll.reverseList();
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

        // 循环链表
        SingleLinkedList sll = new SingleLinkedList();
        SingleNode head = new SingleNode(0, null);
        sll.add(head);
        for (int i = 1; i < 10; i++) {
            SingleNode node = new SingleNode(i, null);
            sll.add(node);
        }
        SingleNode sn = new SingleNode(111, null);
        sll.add(sn);
        for (int i = 10; i < 20; i++) {
            SingleNode node = new SingleNode(i, null);
            sll.add(node);
        }
        // 最后一个结点的next指向之前添加的某个结点。
        SingleNode last = new SingleNode(222, sn);
        sll.add(last);

        // 判断单向链表中是否有环
//        Boolean isCycle = sll.hasCycleByHashSet(head);
        Boolean isCycle = sll.hasCycleByTowPointers(head);
        if (isCycle) {
            System.out.println("is Cycle");
            sll.logCycle("cycle");
        } else {
            System.out.println("is not Cycle");
            System.out.println(sll.toString());
        }
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
                first = new SingleNode(value, null);
            } else {
                SingleNode next = get(0);
                SingleNode singleNode = new SingleNode(value, next);
                first = singleNode;
            }
        } else {
            SingleNode prev = get(index - 1);
            SingleNode singleNode = new SingleNode(value, prev.next);
            prev.next = singleNode;
        }
        size++;
        return true;
    }

    public boolean add(int value) {
        return addLast(value);
    }

    /**
     * 向链表末尾添加结点
     *
     * @param node 结点的next指向为null，表示尾结点。
     * @return
     */
    public boolean add(SingleNode node) {
        if (first == null) {
            first = node;
        } else {
            SingleNode last = get(getSize() - 1);
            last.next = node;
        }
        size++;
        return true;
    }

    /**
     * 末尾添加一个特殊结点，形成一个环，为了测试用。
     *
     * @param node 这个node的next指向单项链表中已经存在的结点。
     * @return
     */
    public boolean addCycleNode(SingleNode node) {
        if (getSize() < 2) {
            return false;
        }
        SingleNode last = get(getSize() - 1);
        last.next = node;
        return true;
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
                SingleNode prev = get(index - 1);
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
        SingleNode singleNode = get(index);
        singleNode.setItem(value);
        return true;
    }

    /**
     * 获取角标上的数据。
     *
     * @param index
     * @return
     */
    public SingleNode get(int index) {
        checkElementIndex(index);

        SingleNode x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public SingleNode getFirst() {
        return first;
    }

    public SingleNode getLast() {
        if (getSize() == 0) {
            return first;
        }
        return get(getSize() - 1);
    }


    /**
     * 返回当前容器大小。
     *
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
    public SingleNode reverseList() {
        SingleNode prev = null;
        SingleNode curr = first;
        while (curr != null) {
            SingleNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        logFromHead("reverseList", prev);
        return prev;
    }

    /**
     * 判断单链表中是否有环
     * 借助HashSet来判断。
     *
     * @param head
     * @return
     */
    public boolean hasCycleByHashSet(SingleNode head) {
        Set<SingleNode> set = new HashSet<>();
        SingleNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return true;
            } else {
                set.add(node);
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 判断单链表中是否有环
     * 借助快慢指针来判断。
     *
     * @param head
     * @return
     */
    public boolean hasCycleByTowPointers(SingleNode head) {
        // 排除无数据或者只有一个数据且无闭环的情况
        if (head == null || head.next == null){
            return false;
        }
        SingleNode slow =  head;
        SingleNode fast = head.next;
        while(slow != fast){
            // 判断快指针结点是否为null，如果为null，则说明到达单向链表的结尾了。
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 打印循环链表，需要添加停止条件。
     *
     * @param tag
     */
    public void logCycle(String tag) {
        StringBuilder sb = new StringBuilder();
        if (tag != null && tag.length() > 0) {
            sb.append(tag + ":");
        }
        sb.append('[');
        if (first != null) {
            SingleNode curr = first;
            int count = 0;
            int limit = getSize();
            while (curr != null && count <= limit) {
                sb.append(String.valueOf(curr));
                if (curr.next != null && count < limit) {
                    sb.append(",").append(" ");
                }
                curr = curr.next;
                count++;
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 根据单向链表的head结点，依次打印单向链表中各个节点的值。
     *
     * @param head
     */
    public void logFromHead(SingleNode head) {
        logFromHead(null, head);
    }

    /**
     * 根据单向链表的head结点，依次打印单向链表中各个节点的值。
     *
     * @param tag
     * @param head
     */
    public void logFromHead(String tag, SingleNode head) {
        System.out.println(getToString(tag, head));
    }

    public String getToString(String tag, SingleNode head) {
        StringBuilder sb = new StringBuilder();
        if (tag != null && tag.length() > 0) {
            sb.append(tag + ":");
        }
        sb.append('[');
        if (head != null) {
            SingleNode curr = head;
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
        return getToString(SingleLinkedList.class.getSimpleName(), first);
    }

}
