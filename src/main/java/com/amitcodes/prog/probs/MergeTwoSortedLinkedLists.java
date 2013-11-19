package com.amitcodes.prog.probs;

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

    public SinglyLinkedListNode mergeIterative() {

        return null;
    }
}
