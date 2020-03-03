package implementation;

import interfaces.IDataLoader;
import interfaces.IProjectPopulator;
import pojo.Employee;
import pojo.Project;
import utilities.Utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The type Data loader. IT is used to load the data for all employees and all projects from a file.
 */
public class DataLoader implements IDataLoader {

    //the input data file
    private String dataFile;

    //the populator of the projects
    private IProjectPopulator projectPopulator;

    /**
     * Instantiates a new Data loader.
     *
     * @param dataFile         the data file
     * @param projectPopulator the project populator
     */
    public DataLoader(String dataFile, IProjectPopulator projectPopulator) {
        this.dataFile = dataFile;
        this.projectPopulator = projectPopulator;
    }

    /**
     * Load list of employees from data file.
     *
     * @return the list
     */
    public List<Employee> load() {

        Map<Integer, Employee> employees = new HashMap<>();

        InputStream in = null;
        if (dataFile.contains(":")) {
            final File initialFile = new File(dataFile);
            try {
                in = new DataInputStream(new FileInputStream(initialFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            in = DataLoader.class.getResourceAsStream(dataFile);
        }

        try (InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            br.lines().forEach(line -> {
                String[] data = line.split(", ");
                loadEmployee(employees, data);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<Employee>(employees.values());
    }

    /**
     * Populates a map of employees from an array. The array is a line from the file split by ", ".
     *
     * @param employees
     * @param data
     */
    private void loadEmployee(Map<Integer, Employee> employees, String[] data) {

        int empId = Utils.parseInt(data[0]);
        if (empId >= 0) {
            Employee employee = null;
            if (employees.get(empId) == null) {
                employee = new Employee(empId);
                employees.put(empId, employee);
            } else {
                employee = employees.get(empId);
            }

            Optional<Project> projectOptional = projectPopulator.populateProject(data);
            if (projectOptional.isPresent()) {
                employee.addProject(projectOptional.get());
            }
        }
    }
}