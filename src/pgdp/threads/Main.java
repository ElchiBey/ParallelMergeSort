package pgdp.threads;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args){
        Comparable[] array = {5, 4, 7, 2, 6, 3, 1};
//        MergeSort.mergesort(array);

        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ParallelMergeSort sort = new ParallelMergeSort(array);
        forkJoinPool.invoke(sort);

        for(Comparable a: array){
            System.out.println(a);
        }
    }
}
