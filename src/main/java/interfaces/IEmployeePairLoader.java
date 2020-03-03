package interfaces;

import pojo.EmployeePair;

import java.util.List;

/**
 * The interface Employee pair loader.
 */
public interface IEmployeePairLoader {

    /**
     * Load list.
     *
     * @return the list
     */
    List<EmployeePair> load();
}