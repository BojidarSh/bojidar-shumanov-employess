package pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Employee pair POJO. It represents a pair of employees which have worked together on common projects.
 */
public class EmployeePair implements Comparable<EmployeePair> {

    //the id of the first employee of the pair
    private int firstEmployee;

    //the id of the second employee of the pair
    private int secondEmployee;

    //List of projects on which the two employees worked together. The time is exactly the time they have worked together.
    // It is intersection between both times of the work executed by the two employees.
    private List<Project> projects;

    /**
     * Instantiates a new Employee pair.
     *
     * @param firstEmployee  the first employee
     * @param secondEmployee the second employee
     */
    public EmployeePair(int firstEmployee, int secondEmployee) {
        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;

        projects = new ArrayList<>();
    }

    /**
     * Gets first employee.
     *
     * @return the first employee
     */
    public int getFirstEmployee() {
        return firstEmployee;
    }

    /**
     * Gets second employee.
     *
     * @return the second employee
     */
    public int getSecondEmployee() {
        return secondEmployee;
    }

    /**
     * Add project.
     *
     * @param project the project
     */
    public void addProject(Project project) {
        this.projects.add(project);
    }

    /**
     * Gets projects.
     *
     * @return the projects
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Gets total time. It sums the times of all projects in the list,
     * so the total time the two employees which worked together is calculated.
     * The method is used in {@link EmployeePair#compareTo(EmployeePair)} in order to
     * be able to compare times of different pairs and provide a way of sorting a list of pairs.
     *
     * @return the total time
     */
    public long getTotalTime() {
        long sum = 0;
        for (int i = 0; i < this.projects.size(); i++) {
            sum += this.projects.get(i).getTime();
        }
        return sum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmployeePair.class.getSimpleName() + "[", "]")
                .add("firstEmployee=" + firstEmployee)
                .add("secondEmployee=" + secondEmployee)
                .add("projects=" + projects)
                .add("totalTime=" + getTotalTime())
                .toString();
    }

    @Override
    public int compareTo(EmployeePair o) {
        return Long.valueOf(this.getTotalTime()).compareTo(Long.valueOf(o.getTotalTime()));
    }
}
