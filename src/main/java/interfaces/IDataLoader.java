package interfaces;

import pojo.Employee;

import java.util.List;

/**
 * The interface Data loader.
 */
public interface IDataLoader {

    /**
     * Load list.
     *
     * @return the list
     */
    List<Employee> load();
}