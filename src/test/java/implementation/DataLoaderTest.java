package implementation;

import interfaces.IDataLoader;
import interfaces.IProjectPopulator;
import org.junit.Test;
import pojo.Employee;
import utilities.Utils;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * The type Data loader test.
 */
public class DataLoaderTest {

    private IDataLoader dataLoader;

    private IProjectPopulator projectPopulator;

    /**
     * Tests {@link DataLoader#load()}.
     */
    @Test
    public void load() {

        projectPopulator = new ProjectPopulator();
        dataLoader = new DataLoader(Utils.DATA_FILE, projectPopulator);
        List<Employee> employees = dataLoader.load();

        assertNotNull(employees);
        assertEquals(3, employees.size());
        assertEquals(143, employees.get(2).getId());
        assertEquals(845, employees.get(2).getProject(10).getTime());
    }
}