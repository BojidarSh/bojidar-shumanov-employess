package implementation;

import interfaces.IDataLoader;
import interfaces.IEmployeePairLoader;
import pojo.Employee;
import pojo.EmployeePair;
import pojo.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Employee pair loader. Loads all possible employee pairs which have worked on projects together.
 * Uses DataLoader to load all employees and after that loads all employees pairs.
 */
public class EmployeePairLoader implements IEmployeePairLoader {

    //the data file
    private String dataFile;

    //the data loader
    private IDataLoader dataLoader;

    /**
     * Instantiates a new Employee pair loader.
     *
     * @param dataFile   the data file
     * @param dataLoader the data loader
     */
    public EmployeePairLoader(String dataFile, IDataLoader dataLoader) {
        this.dataFile = dataFile;
        this.dataLoader = dataLoader;
    }

    /**
     * Returns a list of employee pairs which have worked on mutual projects.
     *
     * @return the list
     */
    public List<EmployeePair> load() {

        List<Employee> employees = dataLoader.load();

        List<EmployeePair> employeePairs = new ArrayList<>();

        for (int i = 0; i < employees.size() - 1; i++) {

            for (int j = i + 1; j < employees.size(); j++) {

                Employee employee = employees.get(i);
                Employee nextEmployee = employees.get(j);

                EmployeePair pair = new EmployeePair(employee.getId(), nextEmployee.getId());

                employee.getProjects().forEach((key, project) -> {
                    Project nextEmplCurrentProject = nextEmployee.getProject(key);
                    if (nextEmplCurrentProject != null) {
                        pair.addProject(new Project(key, Math.abs(project.getTime() - nextEmplCurrentProject.getTime())));
                    }
                });

                if (pair.getProjects().size() > 0) {
                    employeePairs.add(pair);
                }
            }
        }

        return employeePairs;
    }
}
