
import SalaryManagementSystem.Worker;
import SalaryManagementSystem.Generator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WorkersTest {

    @Test
    public void idExistTest()
    {
        Worker [] workers = Generator.workerGenerate(10000);
        List<String> existId = new ArrayList<>();
        for (Worker worker : workers) {
            assertFalse(existId.contains(worker.getId()));
            existId.add(worker.getId());
        }
    }

    @Test
    public void emailExistTest()
    {
        Worker [] workers = Generator.workerGenerate(10000);
        List<String> existEmails = new ArrayList<>();
        for (Worker worker : workers) {
            assertFalse(existEmails.contains(worker.getEmail()));
            existEmails.add(worker.getEmail());
        }
    }

    @Test
    public void phoneNumExistTest()
    {
        Worker [] workers = Generator.workerGenerate(10000);
        List<String> existPhoneNum = new ArrayList<>();
        for (Worker worker : workers) {
            assertFalse(existPhoneNum.contains(worker.getPhoneNum()));
            existPhoneNum.add(worker.getPhoneNum());
        }
    }

    @Test
    public void salaryValidity()
    {
        Worker [] workers = Generator.workerGenerate(10000);
        for (Worker worker : workers)
        {
            assertTrue(3000 <= worker.getSalary() && worker.getSalary() <= 15000);
        }
    }
}
