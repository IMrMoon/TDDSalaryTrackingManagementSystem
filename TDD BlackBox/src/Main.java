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
        Worker[] sortedArr = bubbleSort(workers);
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+1 + ") " + sortedArr[i].getSalary());
        }
        System.out.println("size: " + workers.length);
    }

    public static Worker[] bubbleSort(Worker[] workers){
        int i, j;
        Worker tempWorker;
        boolean swapped;
        Worker[] afterSortingArr = Arrays.copyOf(workers, workers.length);
        for (i = 0; i < afterSortingArr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < workers.length - i - 1; j++) {
                if (afterSortingArr[j].getSalary() > afterSortingArr[j + 1].getSalary()) {
                    tempWorker = afterSortingArr[j];
                    afterSortingArr[j] = afterSortingArr[j + 1];
                    afterSortingArr[j + 1] = tempWorker;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return afterSortingArr;
    }
}