package com.amitcodes.prog.probs;


// Quick sort based on 'Programming Pearls'.
public class QuickSortBasic {


    public void quickSort(int[] a) {
        qsort(a, 0, a.length-1);
    }

    /**
     *
     * x : the array to sort
     * l : lower bound
     * u : upper bound
     */
    void qsort(int[] x, int l, int u) {

        // recursion termination, one element
        if(l>=u) return;
        
        // partition
        int m = partition(x, l, u);

        // recursive calls on each partition
        qsort(x, l, m-1);
        qsort(x, m+1, u);
    }

    int partition(int[] x, int l, int u) {

       // [ t |   <t   |   >=t   ]
       //   ^          ^        ^
       //   l          m        u

        int t=x[l]; // The pivot value
        int m=l;    // 'm' always points to the last min value index
        for(int i=l+1; i<=u; i++) {
            if(x[i] < t){
                swap(x, ++m, i);
            }
        }
        swap(x, l, m); // now ensure that t is placed between the two partitions
        return m;
    }

    void swap(int[] a, int m, int i) {
        int tmp=a[m];
        a[m]=a[i];
        a[i]=tmp;
    }

}