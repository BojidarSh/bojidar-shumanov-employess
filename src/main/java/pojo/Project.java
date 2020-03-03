package pojo;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Project POJO. It represents the projects.
 */
public class Project implements Comparable<Project> {

    //the id of the project
    private int id;

    //the time in days worked on the project
    private long time;

    /**
     * Instantiates a new Project.
     *
     * @param id   the id
     * @param time the time
     */
    public Project(int id, long time) {
        this.id = id;
        this.time = time;
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                time == project.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Project.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("time=" + time)
                .toString();
    }


    @Override
    public int compareTo(Project o) {
        return Long.valueOf(this.time).compareTo(Long.valueOf(o.time));
    }
}
