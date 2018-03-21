package com.amitcodes.prog.probs;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSortBasicUnitTest {
    Logger logger = Logger.getLogger(MergeTwoSortedLinkedListsUnitTest.class.getCanonicalName());

    @Test
    public void testPartition() {
        int[] input  = new int[] { 4,5,3,7,2 };
        int[] output = new int[] { 2,3,4,7,5 };
        
        int m = new QuickSortBasic().partition(input, 0, input.length-1);
        logger.log(Level.INFO, "Partitioned: {0}", Arrays.toString(input));

        Assert.assertEquals(2, m);

        //TODO: change it to use partition attribute that lower < t <= upper.
        for(int i=0; i<input.length; i++) {
            Assert.assertEquals(output[i], input[i]);
        }
    }


    @Test
    public void testQsort() {
        int[] input  = new int[] { 5, 10, 99, 52, 63 };
        int[] output = new int[] { 5, 10, 52, 63, 99 };

        new QuickSortBasic().quickSort(input);
        logger.log(Level.INFO, "Quick Sorted: {0}", Arrays.toString(input));

        for(int i=0; i<input.length; i++) {
            Assert.assertEquals(output[i], input[i]);
        }
    }

    @Test
    public void testQsort_OneMillion() {
        final int NUM_ELEMENTS = 1_000_000;
        Random random=new Random();

        int[] input  = new int[NUM_ELEMENTS];
        for(int i=0; i<NUM_ELEMENTS; i++) {
            input[i] = random.nextInt();
        }
        
        long start = System.currentTimeMillis();
        new QuickSortBasic().quickSort(input);
        long stop = System.currentTimeMillis();

        logger.log(Level.INFO, "Took {0} ms to sort {1} integers", new Object[]{(stop-start), NUM_ELEMENTS} );
        
        for(int i=0; i<input.length-1; i++) {
            Assert.assertTrue(input[i]<=input[i+1]);
        }
    }
}