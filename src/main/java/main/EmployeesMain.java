package main;

import implementation.DataLoader;
import implementation.ProjectPopulator;
import interfaces.IDataLoader;
import interfaces.IEmployeePairLoader;
import interfaces.IProjectPopulator;
import pojo.EmployeePair;
import implementation.EmployeePairLoader;
import utilities.Utils;

import java.util.Collections;
import java.util.List;

public class EmployeesMain {

    //the pair loader
    private static IEmployeePairLoader employeePairLoader;

    //the data loader
    private static IDataLoader dataLoader;

    //the project populator
    private static IProjectPopulator projectPopulator;

    public static void main(String[] args) {

        projectPopulator = new ProjectPopulator();
        dataLoader = new DataLoader(Utils.DATA_FILE, projectPopulator);
        employeePairLoader = new EmployeePairLoader(Utils.DATA_FILE, dataLoader);
        List<EmployeePair> employeePairs = employeePairLoader.load();

        Collections.sort(employeePairs);
        Collections.reverse(employeePairs);

        employeePairs.forEach(employeePair -> System.out.println(employeePair));
    }
}