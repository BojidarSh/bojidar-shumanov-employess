package pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Employee POJO. It represents the employee. It holds a list with all projects.
 */
public class Employee {

    //the id of the employee
    private int id;

    //the projects in which an employee was involved
    private Map<Integer, Project> projects;

    /**
     * Instantiates a new Employee.
     *
     * @param id the id
     */
    public Employee(int id) {
        this.id = id;
        projects = new HashMap();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Add project.
     *
     * @param project the project
     */
    public void addProject(Project project) {
        this.projects.put(project.getId(), project);
    }

    /**
     * Gets project.
     *
     * @param key the key
     * @return the project
     */
    public Project getProject(int key) {
        return this.projects.get(key);
    }

    /**
     * Gets projects.
     *
     * @return the projects
     */
    public Map<Integer, Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("projects=" + projects)
                .toString();
    }
}
