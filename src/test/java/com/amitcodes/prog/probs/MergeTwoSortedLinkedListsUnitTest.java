package com.amitcodes.prog.probs;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeTwoSortedLinkedListsUnitTest
{
    Logger logger = Logger.getLogger(MergeTwoSortedLinkedListsUnitTest.class.getCanonicalName());
    @Test
    public void testMergeRecursive() {
        SinglyLinkedListNode<Integer>
                node1 = createLinkedLists(3),
                node2 = createLinkedLists(4);

        logLinkedList("list1", node1);
        logLinkedList("list2", node2);

        SinglyLinkedListNode<Integer> result =
                new MergeTwoSortedLinkedLists<Integer>().mergeRecursive(node1, node2);

        logLinkedList("result", result);
        verifySorted(result);
    }

    /*****************************************************************
     *                        Utility Methods
     *****************************************************************/
    private void verifySorted(SinglyLinkedListNode<Integer> sorted) {
        SinglyLinkedListNode<Integer>
                node1=sorted,
                node2=sorted.next;

        while (node2 != null){
            Assert.assertTrue(node1.data.compareTo(node2.data) <=0); // node1.data <= node2.data
            node1=node1.next;
            node2=node2.next;
        }

    }

    private SinglyLinkedListNode<Integer> createLinkedLists(int size) {
        // generate N random integers
        List<Integer> data = new ArrayList<>(size);
        Random rand = new Random();
        for (int i=0; i<size; i++) {
            data.add(rand.nextInt());
        }

        // Sort the generated random integers
        Collections.sort(data);

        //Create a sorted linked list
        SinglyLinkedListNode<Integer> node;
        SinglyLinkedListNode<Integer> head = null;
        SinglyLinkedListNode<Integer> tail = null;
        for(Integer e : data) {
            node = new SinglyLinkedListNode<>();
            node.data = e;

            if (head == null) { // init head to first node
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    private void logLinkedList(String listName, SinglyLinkedListNode<Integer> node){
        StringBuilder builder = new StringBuilder();
        while(node != null) {
            builder.append(node.data).append(" -> ");
            node = node.next;
        }
        builder.append("null");

        logger.log(Level.INFO, "{0}: {1}", new Object[]{listName, builder.toString()});
    }
}
