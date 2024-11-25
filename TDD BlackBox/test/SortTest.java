import SalaryManagementSystem.Generator;
import SalaryManagementSystem.Main;
import SalaryManagementSystem.Worker;
import org.junit.Test;

import static SalaryManagementSystem.Main.quickSort;
import static org.junit.Assert.*;


public class SortTest {

    @Test
    public void testSortIfReturnSomething() {
        Worker[] workers = Generator.workerGenerate(10000);
        Worker[] sortedWorkers = quickSort(workers, 0, workers.length - 1);
        assertNotNull(sortedWorkers);
    }

    @Test
    public void testSortIfFullAndSorted(){
        Worker[] workers = Generator.workerGenerate(10000);
        Worker[] sortedWorkers = quickSort(workers, 0, workers.length - 1);
        assertEquals(sortedWorkers.length, workers.length); //to check if anything got lost
        for(int i = 0; i < sortedWorkers.length - 1; i++){
            assertTrue(sortedWorkers[i].getSalary() <= sortedWorkers[i+1].getSalary()); //to check if sorted
        }
    }

}
