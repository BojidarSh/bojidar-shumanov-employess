package main;

import implementation.DataLoader;
import implementation.EmployeePairLoader;
import implementation.ProjectPopulator;
import interfaces.IDataLoader;
import interfaces.IEmployeePairLoader;
import interfaces.IProjectPopulator;
import org.junit.Test;
import pojo.EmployeePair;
import utilities.Utils;

import java.util.Collections;
import java.util.List;

/**
 * Executes the implementation for finding the pair of employees which have worked mostly together.
 */
public class ExecuteProgramTest {

    //the pair loader
    private static IEmployeePairLoader employeePairLoader;

    //the data loader
    private static IDataLoader dataLoader;

    //the project populator
    private static IProjectPopulator projectPopulator;

    /**
     * Executes the implementation.
     */
    @Test
    public void execute() {

        projectPopulator = new ProjectPopulator();
        dataLoader = new DataLoader(Utils.DATA_FILE, projectPopulator);
        employeePairLoader = new EmployeePairLoader(Utils.DATA_FILE, dataLoader);
        List<EmployeePair> employeePairs = employeePairLoader.load();

        Collections.sort(employeePairs);
        Collections.reverse(employeePairs);

        employeePairs.forEach(employeePair -> System.out.println(employeePair));
    }
}