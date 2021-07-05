/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode.listnode;

import com.xiaobobo.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname ListNodeDemo
 * @Date 2021/2/28 下午7:55
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class ListNodeDemo {


    public static void main(String[] args) {
        //ListNode head = ListNode.buildListNode();
        //System.out.println(head.toString());
        // 倒数第k个节点
        //reciprocalKthNode(3, head);
        // 翻转链表(递归)
        //reverseListNode1(head);
        // 翻转链表(头插法)
        //reverseListNode2(ListNode.buildListNode());
        // 两个链表的交点
        //ListNode l1 = ListNode.customListNode(7, 8, 9);
        //ListNode l2 = ListNode.customListNode(1, 2, 3, 4, 5, 6);
        //getIntersectionNode(l1, l2, 3);
        //ListNode l1 = ListNode.customListNode(1, 3, 5, 7, 9);
        //ListNode l2 = ListNode.customListNode(0, 2, 4, 6, 8);
        //mergeTwoLists(l1, l2);
        //ListNode head = ListNode.customListNode(1, 1, 1, 2, 3, 4);
        //deleteDuplicates(head);
        //deleteDuplicates22(head);
        //isPalindrome(ListNode.customListNode(1, 2));
        //oddEvenList(ListNode.customListNode(1,2,3));
        //addTwoNumbers3(ListNode.customListNode(2, 4, 3), ListNode.customListNode(5, 6, 4));
        //isPalindrome2(ListNode.customListNode(1,2));
        //isPalindrome(ListNode.customListNode(1,2,3,4,3,2,1));
        //reorderList(ListNode.customListNode(1, 2, 3, 4, 5));
        reverseListNode2(ListNode.customListNode(1, 2, 3, 4, 5));

    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode front = head;
        ListNode tailOrder = slow.next;
        slow.next = null;
        ListNode tail = reverse(tailOrder);

        while (front != null && tail != null) {

            // 后面链表拿到第一个
            ListNode tailTop = tail;
            tail = tail.next;
            tailTop.next = null;

            ListNode next = front.next;
            front.next = tailTop;
            tailTop.next = next;
            front = front.next.next;
        }
        return head;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) return false;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                stack1.push(cur1.val);
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                stack2.push(cur2.val);
                cur2 = cur2.next;
            }
        }
        ListNode res = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = val1 + val2 + carry;
            carry = sum > 9 ? 1 : 0;
            ListNode curNode = new ListNode(sum % 10);
            curNode.next = res;
            res = curNode;
        }

        return res;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        while (cur != null) {
            cur.val += l2.val;
            l2 = l2.next;
            cur = cur.next;
        }
        cur = l1;
        while (cur != null) {
            if (cur.val >= 10) {
                cur.val -= 10;
                if (cur.next == null) {
                    cur.next = new ListNode(1);
                } else {
                    cur.next.val += 1;
                }

            }
            cur = cur.next;
        }
        return l1;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            int cur1Val = cur1.val;
            int cur2Val = cur2.val;
            cur1.val += cur2Val;
            cur2.val += cur1Val;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }


        if (cur1 != null) {
            cur1 = l1;
            while (cur1 != null) {
                // 需要进一位
                if (cur1.val > 9) {
                    if (cur1.next == null) {
                        cur1.next = new ListNode(1);
                    } else {
                        cur1.next.val++;
                    }
                    cur1.val -= 10;
                }
                cur1 = cur1.next;
            }
            return l1;
        } else {
            cur2 = l2;
            while (cur2 != null) {
                // 需要进一位
                if (cur2.val > 9) {
                    if (cur2.next == null) {
                        cur2.next = new ListNode(1);
                    } else {
                        cur2.next.val++;
                    }
                    cur2.val -= 10;
                }
                cur2 = cur2.next;
            }
            return l2;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode oddCur = head;
//        oddHead.next = null;
//        oddTail.next = null;
//        oddCur.next = null;

        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        ListNode evenCur = head.next;
//        evenHead.next = null;
//        evenTail.next = null;
//        evenCur.next = null;

        ListNode cur = head.next.next;
        int index = 3;

        while (cur != null) {
            //奇数
            if (index % 2 == 1) {
                oddCur.next = cur;
                oddCur = oddCur.next;
                oddTail = oddCur;
                cur = cur.next;
                oddTail.next = null;
            }
            //偶数
            else {
                evenCur.next = cur;
                evenCur = evenCur.next;
                evenTail = evenCur;
                cur = cur.next;
                evenTail.next = null;
            }
            index++;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            ListNode cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static ListNode deleteDuplicates22(ListNode head) {
        ListNode temp = new ListNode(-999);
        temp.next = head;
        ListNode cur = temp;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                cur.next = getNode(cur.next, cur.next.val);
            }
        }
        return temp.next;
    }

    private static ListNode getNode(ListNode node, int val) {
        if (node == null || node.val != val) {
            return node;
        }
        return getNode(node.next, val);
    }


    public static void deleteDuplicates(ListNode head) {
        System.out.println("原链表：" + head);
        ListNode node = deleteDuplicatesWithReturn(head);
        System.out.println("无重复节点的链表：" + node);
    }

    public static ListNode deleteDuplicatesWithReturn(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicatesWithReturn(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     */
    public static void mergeTwoLists(ListNode l1, ListNode l2) {
        System.out.println("合并前的链表1：" + l1);
        System.out.println("合并前的链表2：" + l2);
        ListNode listNode = mergeTwoListsWithReturn(l1, l2);
        System.out.println("合并后的链表：" + listNode);
    }

    public static ListNode mergeTwoListsWithReturn(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsWithReturn(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsWithReturn(l1, l2.next);
            return l2;
        }
    }

    /**
     * 构造两链表的交点
     */
    private static void getIntersectionNode(ListNode originalNode, ListNode node, int k) {
        // 构造交点链表
        ListNode headA = buildIntersectionNode(originalNode, node, k);
        ListNode headB = node;
        System.out.println("headA: " + headA);
        System.out.println("headB: " + headB);
        ListNode intersectionNode = getIntersectionNodeWithReturn(headA, headB);
        System.out.println("两链表交点的值为：" + intersectionNode.val);
    }

    private static ListNode buildIntersectionNode(ListNode originalNode, ListNode node, int k) {
        ListNode next = reciprocalKthNodeWithReturn(k, node);
        ListNode cur = originalNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = next;
        return originalNode;
    }

    private static ListNode getIntersectionNodeWithReturn(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    /**
     * 翻转链表
     *
     * @param head
     */
    private static void reverseListNode2(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = next;
        }
        System.out.println(newHead.next);
    }
    private static void reverseListNode1(ListNode head) {
        ListNode reversedListNode = reverse(head);
        System.out.println(reversedListNode);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 倒数第k个节点
     * 双指针法
     * 一个指针先走k步，等先走的指针。到头以后。慢的指针就是所求的值
     */
    public static void reciprocalKthNode(int k, ListNode head) {
        ListNode node = reciprocalKthNodeWithReturn(k, head);
        System.out.println("链表倒数第" + k + "个节点的值为：" + node.val);
    }

    public static ListNode reciprocalKthNodeWithReturn(int k, ListNode head) {
        int flag = 1;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            if (flag < k) {
                fast = fast.next;
                flag++;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
