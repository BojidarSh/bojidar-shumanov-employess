package implementation;

import interfaces.IDataLoader;
import interfaces.IEmployeePairLoader;
import interfaces.IProjectPopulator;
import org.junit.Test;
import pojo.EmployeePair;
import utilities.Utils;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * The type Employee pair loader test.
 */
public class EmployeePairLoaderTest {

    private IProjectPopulator projectPopulator;

    private IDataLoader dataLoader;

    private IEmployeePairLoader employeePairLoader;

    /**
     * Tests {@link EmployeePairLoader#load()}.
     */
    @Test
    public void load() {

        projectPopulator = new ProjectPopulator();
        dataLoader = new DataLoader(Utils.DATA_FILE, projectPopulator);
        employeePairLoader = new EmployeePairLoader(Utils.DATA_FILE, dataLoader);

        List<EmployeePair> employeePairs = employeePairLoader.load();

        assertNotNull(employeePairs);
        assertEquals(2, employeePairs.size());
        assertEquals(218,employeePairs.get(1).getFirstEmployee());
        assertEquals(143,employeePairs.get(1).getSecondEmployee());
    }
}