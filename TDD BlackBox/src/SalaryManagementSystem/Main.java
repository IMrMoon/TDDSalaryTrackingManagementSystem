package SalaryManagementSystem;

import SalaryManagementSystem.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Worker[] workers = Generator.workerGenerate(10000);
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+1 + ") " + workers[i].getSalary());
        }
        long startTime = System.currentTimeMillis();
        Worker[] sortedArr = quickSort(workers, 0, 9999);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+1 + ") " + sortedArr[i].getSalary());
        }
        System.out.println("size: " + workers.length);
        System.out.println("sort duration: [" + duration + "] MilliSec");
    }
///O(n^2) bubbleSort
//    public static Worker[] bubbleSort(Worker[] workers){
//        int i, j;
//        Worker tempWorker;
//        boolean swapped;
//        Worker[] afterSortingArr = Arrays.copyOf(workers, workers.length);
//        for (i = 0; i < afterSortingArr.length - 1; i++) {
//            swapped = false;
//            for (j = 0; j < workers.length - i - 1; j++) {
//                if (afterSortingArr[j].getSalary() > afterSortingArr[j + 1].getSalary()) {
//                    tempWorker = afterSortingArr[j];
//                    afterSortingArr[j] = afterSortingArr[j + 1];
//                    afterSortingArr[j + 1] = tempWorker;
//                    swapped = true;
//                }
//            }
//            if (!swapped)
//                break;
//        }
//        return afterSortingArr;
//    }

    ///O(nlogn) quickSort
    public static Worker[] quickSort(Worker[] workers, int left, int right) {
        if (left < right){
            int partition_index = partition(workers, left, right);

            quickSort(workers, left, partition_index - 1);
            quickSort(workers, partition_index + 1, right);
        }
        return workers;
    }

    public static void swap(Worker[] workers, int i, int j) {
        Worker temp = workers[i];
        workers[i] = workers[j];
        workers[j] = temp;
    }

    public static int partition(Worker[] workers, int left, int right) {
        int pivot = workers[right].getSalary();
        int i = left - 1;

        for (int j = left; j <= right - 1; j++) {
            if (workers[j].getSalary() < pivot){
                i++;
                swap(workers, i, j);
            }
        }
        swap(workers, i + 1, right);
        return i + 1;
    }
}