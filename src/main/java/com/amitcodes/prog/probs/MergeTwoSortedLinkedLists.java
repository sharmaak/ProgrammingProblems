package com.amitcodes.prog.probs;

/**************************************************************
 * You have two singly linked lists that are already sorted,
 * you have to merge them and return a the head of the new
 * list without creating any new extra nodes. The returned
 * list should be sorted as well.
 **************************************************************/
public class MergeTwoSortedLinkedLists<T extends Comparable<T>>
{
    /*************************************************************
     * The logic is
     *   1. Of the two nodes passed, keep the node with smaller
     *      value
     *   2. Point the smaller node's next to the next smaller
     *      value of remaining of the two linked lists
     *   3. Return the current node (which was smaller of the
     *      two nodes passed to the method)
     *
     *  Based on logic posted by 'Stefan Haustein' on
     *  http://stackoverflow.com/a/10707528
     **************************************************************/
    public SinglyLinkedListNode<T> mergeRecursive(SinglyLinkedListNode<T> node1, SinglyLinkedListNode<T> node2) {

        // Termination condition 1:
        // If anyone of the lists is exhausted, return the other list
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        // Return the smaller of the two nodes passed.
        // Point smaller node's next to the next smaller
        // node in the residual lists.
        if(node1.data.compareTo(node2.data) < 0) { // is node1.data < node2.data ?
            node1.next = mergeRecursive(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeRecursive(node2.next, node1);
            return node2;
        }
    }

    /*
     * The iterative approach. Better for all practical purposes! Scales as size of lists swells up.
     *
     * The approach is to treat one of the sorted linked lists as list, and treat the other sorted
     * list as `bag of nodes'. Then we lookup for correct place for given node (from bag of nodes)
     * in the list.
     *
     * Based on logic posted by 'Stefan Haustein' on
     * http://stackoverflow.com/a/10707986/459185
     * */
    public SinglyLinkedListNode<T> mergeIterative(SinglyLinkedListNode<T> node1, SinglyLinkedListNode<T> node2) {

        if(node1 == null) return node2;
        if(node2 == null) return node1;

        //1. Determine the list whose first node has lesser value of the two
        //2. Set list from 1 as list1 (fixed list). Treat the other list
        //   (list2) as the list whose elements have to be injected in list1.
        //3. Point head to list1. We shall finally return `head'
        SinglyLinkedListNode<T> head;
        if(node1.data.compareTo(node2.data)<=0) { // node1.data <= node2.data
            head = node1;
        } else {
            // Swap node1 and node2.
            // Head points to the list with lesser-head
            // `node1' always pointer to the lesser list
            head = node2;
            node2 = node1;
            node1 = head;
        }

        // Beyond this point node1 is the list with lesser-head
        // and node2 is the list with greater-head.
        while (node1.next != null && node2 != null) {
            if (node1.next.data.compareTo(node2.data) > 0) { // node2.data < node1.next.data
                // since node1.data < node2 < node1.next.data,
                // insert node2 between node1 and node1.next
                SinglyLinkedListNode<T> tmp = node2.next;
                node2.next = node1.next;
                node1.next = node2;
                node2 = tmp;
            }
            // move to the next node of the fixed list
            node1 = node1.next;
        }

        // If list1 is exhausted, append all the remaining items of list2 to list1
        if (node1.next == null) { node1.next = node2; }
        // Return the head
        return head;
    }
}
