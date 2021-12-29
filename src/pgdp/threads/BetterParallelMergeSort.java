package pgdp.threads;

import java.util.concurrent.RecursiveAction;

public class BetterParallelMergeSort extends RecursiveAction {

    private Comparable[] array;
    private int low, mid, high, size;

    public BetterParallelMergeSort(Comparable[] array) {
        Comparable[] helper = new Comparable[array.length];
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(array, helper, 0, array.length - 1);
    }

    public BetterParallelMergeSort(Comparable[] array, Comparable[] helper, int leftIndex, int rightIndex) {
        this.array = array;
        low = leftIndex;
        high = rightIndex;
        mid = (low + high) / 2;
    }

    @Override
    protected void compute() {
        if (size > 5000) {
            if (low < high) {

                ParallelMergeSort left = new ParallelMergeSort(array, new Comparable[mid], low, mid);
                ParallelMergeSort right = new ParallelMergeSort(array, new Comparable[array.length - mid], mid + 1, high);

                invokeAll(left, right);

                MergeSort.merge(array, new Comparable[array.length], low, mid, high);
            }
        }
        else if (low < high){
            MergeSort.merge(array, new Comparable[array.length], low, mid, high);
        }
    }
}
